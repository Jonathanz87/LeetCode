public class PiiEncryptor {
	private static final String KEY_FORMAT = "%s.%s";

	private static final Map<Class<?>, Function<String, ?>> CONVERTER_MAP = new HashMap<>();

	static {
		CONVERTER_MAP.put(int.class, Integer::parseInt);
		CONVERTER_MAP.put(Integer.class, Integer::parseInt);
		CONVERTER_MAP.put(long.class, Long::parseLong);
		CONVERTER_MAP.put(Long.class, Long::parseLong);
		CONVERTER_MAP.put(String.class, s -> s);
	}


	public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
		TestClass testClass = new TestClass();
		testClass.setI("10");
		testClass.setInteger("20");
		testClass.setL("2000");
		testClass.setS("String");

		List<TestClass> list = new LinkedList<>();
		list.add(testClass);

		Map<String, String> map = mapify(list);

		for (Map.Entry<String, String> e : map.entrySet()) {
			e.setValue(e.getValue() + "modified");
		}

		valueSwap(list, map);

		list.forEach(System.out::println);
	}

	private static <T> Map<String, String> mapify(List<T> list) throws IllegalAccessException {
		Map<String, String> map = new HashMap<>();
		for (int i = 0, len = list.size(); i < len; i++) {
			T obj = list.get(i);
			for (Field f : obj.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				String value = f.get(obj).toString();
				map.put(String.format(KEY_FORMAT, i, f.getName()), value);
			}
		}

		return map;
	}

	private static <T> void valueSwap(List<T> list, Map<String, String> valueMap) throws NoSuchFieldException,
		IllegalAccessException {
		for (Map.Entry<String, String> e : valueMap.entrySet()) {
			String[] key = e.getKey().split("\\.");
			T obj = list.get(Integer.parseInt(key[0]));
			Field f = obj.getClass().getDeclaredField(key[1]);
			f.setAccessible(true);
			f.set(obj, CONVERTER_MAP.get(f.getType()).apply(e.getValue()));
		}
	}

	private static class TestClass {
		private String i;
		private String s;
		private String l;
		private String integer;

		public String getI() {
			return i;
		}

		public void setI(String i) {
			this.i = i;
		}

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}

		public String getL() {
			return l;
		}

		public void setL(String l) {
			this.l = l;
		}

		public String getInteger() {
			return integer;
		}

		public void setInteger(String integer) {
			this.integer = integer;
		}

		@Override
		public String toString() {
			return "TestClass{" +
			       "i='" + i + '\'' +
			       ", s='" + s + '\'' +
			       ", l='" + l + '\'' +
			       ", integer='" + integer + '\'' +
			       '}';
		}
	}
}