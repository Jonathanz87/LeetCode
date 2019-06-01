
/*
    1048. Longest String Chain
    Given a list of words, each word consists of English lowercase letters.
    Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.
    For example, "abc" is a predecessor of "abac".
    A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, 
    where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
    Return the longest possible length of a word chain with words chosen from the given list of words.
    Example 1:
        Input: ["a","b","ba","bca","bda","bdca"]
        Output: 4
        Explanation: one of the longest word chain is "a","ba","bda","bdca".
    Note:
        1 <= words.length <= 1000
        1 <= words[i].length <= 16
        words[i] only consists of English lowercase letters.
*/

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[] { "xiktrzpllggpfhyz", "xpvsadeteueapiix", "zmorruxheofxuzex",
                "bktrzyuehqwflufv", "wqisffnotrirxbcp", "aconyfdaykglfxav", "pairidyzwwudqyta", "sdzwiexpiyzgnhgc",
                "lzlyojxrzptucbkf", "ksarxkcvqlhxurlz", "kjbarurxolakwihg", "spsiggyyvgiuhphk", "zezawnaquzluvuvn",
                "emeqduevvcznedgp", "owjtxugswkrxwzfz", "cshycwyzsxvjhrbt", "ynkncdozldfbqnfj", "iwovhiehaccvatgz",
                "dqhunbmsjpthcdfw", "lgsnkmoqmxvfkiwa", "momznchoxeidauve", "yszsqqkkgbhmcywc", "jmsxlhcbjmfcbyii",
                "fpffixflnkkrbijp", "nljoruhzvlbbgkar", "mgvztbcaxiizxafw", "fwyesmzklxikhucs", "cvhqnzhvzqqugkzq",
                "evlvkhkhvektaqzv", "yoamimsgybrjiysh", "puzqcdprgfoifrpk", "wsabcyxsvguqjlwo", "ynvplivbamsjhadj",
                "vzclfnoyzwqgwdkn", "hyplcmrdekcbbeyn", "rppdgwoazxeprgfl", "evfnvtptdrdpffzw", "jsspmpfqglybfybg",
                "eddmsykvjikawpay", "lnwunpmynuaqvfol", "pcyzxbevkkwqqzpp", "ywfczslwhstbqfbr", "htgpgymwsfxrnrye",
                "nzqwprxcxsekojei", "hbrcljojxswrhoyv", "jqzveafebmxtyfss", "ckdfgaolrhzxixnh", "ivzcajsvoptxootv",
                "qoqewvcuupgmkivu", "shhlxmishdntfhlo", "wjmkzlpalxmfzcgn", "mepokparotrqnemv", "vtsqliqsbmzbllgb",
                "zmnkmggbhnxloaap", "endivarwladtznjm", "sembmqbmcrjyujcr", "nbbfkdqbtlhaokaa", "jwaxklstistompuy",
                "phimhmzcsttecexa", "epipamvsepcdtbiz", "zgspvaobuqnexcwe", "uvrvpfxyhtvzlicj", "wlylymcdftakkkqa",
                "oisjvrsmegjixnnb", "jpnrprfzgbywheel", "aziiguuaqbdahzjx", "rygswbtmahxvhwbk", "ahswzmqbaubxspac",
                "nntlulwoozdaexyd", "appbjriqggjsyzoe", "xxxgwrsvieuegjkq", "pnzubazuvvfnmqvk", "niynekxdblbrkwpz",
                "wqrptmyzblryrrrg", "mvluaslaelyxckfq", "nwhssmjrpilcxrmt", "dlxclhgmntznfhcm", "dftdsjboiafzvkkz",
                "acadbdleuxfmbxqc", "qaqpasmynpxfjdsw", "hvwrunfcclbhevpj", "yzvunptcshgotdlv", "kgotgvctpyfxbcoh",
                "lljzznkehauqewie", "vffuplsorjjdthhp", "zmreuskfdbprryaw", "kviuixrytezksbot", "kophvascdsbownac",
                "jivnmjrizuwtazax", "cyadbnavjljctafv", "bemhrieubmxyuwfv", "oddludjpryyfzbeq", "wphjknashuwimbxf",
                "npizyejuohihhzzt", "dykbvtgfgeekrgoi", "cmhjucdtgtwtiwas", "rjqskbawrmnzshnt", "ofywvslglhkaiumn",
                "pvueaekdrnnprnky", "ueryzfsugvvslvol", "olbzohuhofshstpa", "rgmosneefyykwylr", "xuribzbmsltjopqo",
                "ontfyozarnhgdstb", "dyvccexekxphwcko", "rsdvnxgjbpjcnnvh", "dpnrtkqkxuwldacd", "yncimflzgqqrzoqc",
                "hgsaprfvnweeeewu", "hdkzblepnxuyjhlf", "jvvbgwlscpzizapl", "vdffkheluhyojtnh", "mermqeejjlafbmxd",
                "uyvuvbqdytscnfyz", "lrtbyxwxyddyaxtf", "gedmrchbqgvkotmi", "qlcowjpuvkfjqxum", "oftdpsytaduihcxd",
                "obajpmwhejqsblci", "twssfmikespenbzr", "wnnqzpfiiuwwfuuv", "ukhdpagsnzqdmact", "vwfyvxkjzhbupmlw",
                "xngmdijsjvvtyvtq", "rgubdakwbpkxioci", "huplukfiojyacfkj", "nsdmrjpqsdukdpew", "smfkhpygclpurxqf",
                "fxmbyktwczcgynkc", "tfztrnpvdlfmkgbe", "nkhojszihwhhquwa", "tdbslimcyhqfvrok", "vpzqjxdnhslpuflc",
                "mdzvaomxztaxksdu", "glnqtpmeorbiadte", "gczbrhnfdqgajzgf", "rwdkhzmbqzmvlwcs", "mlntmvimjylsujlz",
                "wmiefnldbraymkju", "lpaviqjiycarwesn", "zdqyqgutpbfxmpxn", "qzltbkakofafidqd", "cpahjjkgmibthjzf",
                "dyoxushnollyftme", "cyrhvyophhfyddjx", "sbxrvfigixujebht", "nvqoqxxrazujtyeh", "paazqdfhkdwaqkmv",
                "rjldzftqhtmylykc", "kowftuamqixgfqmt", "rxfesuqxnapimrmq", "ytkpfytwwnydthmu", "iyczlvslsithmkmw",
                "lkhsvjtqxzkddrhk", "zlbfpluogpujathk", "dghnjblmsdwzezgy", "hmklqpzpyqlvzive", "llzigsbqpotjmjee",
                "dtzckprahpkdelac", "cuhpbxoxzqhicaph", "xcwfocnwumvkmeqp", "fgtnwsabjkmolrpc", "hzcujbznyakrcpsm",
                "aemewyoawdmwhfwk", "hqmippezmqpcymuf", "wymqfukkhawuxqiw", "pjufiaqyvngbhbrn", "qhwmkmsysiyikmff",
                "wopvhgumesumbjxy", "spiokgvbnilenzuw", "yyudbokugnuncqoe", "jnlybhmotnwqparz", "usjnrlqwypjlzocr",
                "ystpdsqmjylnnxvq", "rxjjkqqytayovkaf", "nfyocvpvbhqdfwss", "xxcjwqtdqpvntoeg", "dtqakeyreorapbrq",
                "ioytgpelskuipmav", "arebazhqaqewubpr", "ojaljxttzhagaxcq", "bbashltmuxjmzajl", "msxqgbvyngfxuffz",
                "sayhyhbttspffmea", "dojhjxqysqjtpfba", "zbduzbujxtzkviub", "lksprbncaureecjh", "mrngtsyoncuishfs",
                "dqfnagsokobmfmoo", "eqwcfzdvijsaqmlq", "najyizvppgkpitdr", "ondnlppfjzwdgxnj", "ksqtbgzqivhpbfdc",
                "ymfoipmguqszggvl", "jdnfzajaaqumnxyj", "hwzcimzuqscvnjfs", "nkrdjkjwsmkqdsrb", "jehdirdqvsdgamin",
                "sdrlhblfhbdvgfyq", "kvblhbikpiyfeyve", "jbyamqdrqxvoyefa", "wsmarkjrffzaieod", "nspqxdgactlpvpqm",
                "sfiyfkvkwhobjvdq", "lfkdeuaktpifcjng", "roagvbtztkgmkvqg", "wlkdznewqkhkewdx", "seiwzsfttlqfdadv",
                "yuceesivscgmyrrc", "ojtexjphdrhmsprz", "wcucwofaizczofjs", "klczhgljhzzsuvak", "evuifhwdydndsxxt",
                "hcdwpymrqjygylum", "ryfusxexyfnilwom", "epcupjuzvfjwuiad", "buqotlgepgqftmmc", "pdsnynulyfniyuzs",
                "vvmyhsaxyvovbdqp", "qqtqcffokvzgmlgo", "hzewuqlucekopklg", "toybrsyhzaujhdrc", "efvruspjvsnmliro",
                "yzoxwpspebhetqvv", "rarfzsudtbmzoypu", "aquyojszfkaokotd", "fitbwlfqvhnwrtax", "hvvscnwgceuznchj",
                "zsmxhzbyhkpnswug", "qfonmsqvdkudqaiq", "nyaxjhptoarlmnky", "tfibnnvdjrvycztd", "vynuzqdnfzfmwaqf",
                "zrpuaohviipjexed", "zahuitenwcxymrad", "sujmcuphqzesaipy", "uznbydacfbxbeegk", "ubbinzehagmzcogg",
                "mrwojblmmbjtmfze", "hqapxztodlfaljfy", "wiamundsnczdyvjb", "pbyclnvkyudkajfe", "szkhlwkwyolxrrpy",
                "jmwverfcekgvtkod", "ejdtuncxjobpirwg", "xqwfvkzisrsnwplr", "tmaqyvgfkfhewcdx", "xumoyodfmqrmnzmk",
                "mgtpddcpyuzmlxpc", "mmnocpibybafvwrq", "kwizksnmhzeiqrns", "vpawfsjjpfvjwbvg", "lldygnmrkxhzescs",
                "mbikmxubsrqxqbhu", "jbxlnxuuvzjrrexf", "emgybzkmqxmdchpf", "kklcxkdckwzevmde", "ozlmogdvnqepreck",
                "jzygzibnyxuxdcsx", "oklynnzxkqcgzpiu", "lprxrfjzymfjqgwg", "jmokfkaocybmjask", "juptrygjxjzdeeub",
                "ufstbspzhkrppprp", "ighmbeckwdjrnoos", "guvkcqtmmylmnyck", "tizidkensluzgyvh", "iwsofcdjxjfhngxs",
                "jffseqvzsckhnrnn", "hgoqoiawrwnlyngz", "erxhpdltdssscuon", "oiasxoyahyaxqatk", "kefbwqepjggbvebx",
                "qmmbzltxgdzylbbv", "jctvfmwrbwzwtima", "kcxspccwpuxivzit", "cvmysypziuonbfgh", "epsmrspexkznyrnj",
                "vwquqjykfixtbyot", "loxsdumstqhhpjif", "sggvhefovvvpffpd", "uljipogohwwivvbt", "idxthvlxlspocoyd",
                "imctxvlmvjbtyeyi", "bgkotxifetnnacwm", "tqykskbwquulvikt", "cvjjfaxnnetixidp", "xchygwwfqajkrwvp",
                "zjukjirmyewadosy", "cnwcnpwarvyfpwtp", "dbtolrkvvlzxesai", "jrlpuaomdcenttzm", "ehqirdljbxdxmvxe",
                "wxrmnixoxsteemmd", "xitrbxrdacsotmtj", "dlwmafzothymbuae", "ygfksnszzcgglqur", "lenkvahauisijaxs",
                "xajlwcxsxzoiojsl", "dwisrywksldxjxdi", "bbbhsalznmefauho", "jumkzqoyfyborsaj", "inpsilobcuuxtgoi",
                "mymrqhuvwisrmexk", "grnjrmehiqlgcpbz", "sgsaxezwlpgtiymk", "mfslwhaphtprtaxc", "zdxqhvndadhloqpz",
                "ncjfkzimkwogclax", "iqpaohyzfksttazm", "rmoqdtymviqsjniz", "rtkcymghagoaqqqg", "dwhdbvcnbznacbjz",
                "zoeswywxfgirujup", "pfjsjvvrhcaxxwjs", "ydrdgvrxgnnwpnjd", "lfrrgamvzazpbitq", "ijshitmmlsyyjmyc",
                "tgvqkjwgrtuzxvll", "alhpfpagcohodqvw", "wtixmmpfzuiyzhsf", "xqijnoiuvepnyqfs", "qmnqohcoxusausjs",
                "meaaacbykxmdbvkz", "oxvjobihweqdysfd", "dqsjyjymwweoixop", "bipeqynjfbsbcsqr", "zenwqxbazquebegu",
                "qejxdoxhevoxemds", "uswoispqfjbpydsb", "ibsgttnszzqhtmwc", "pnkryvxcagddabjf", "wpegggnqckqguaae",
                "shaqmjnduaqbnzxf", "jonthlxvetudyfhg", "mklelncpthmpcehu", "vgeudpxslqrrijra", "ihxttlctrwdufhez",
                "iryczxurgxrzfajf", "mcewoovlrvwijjem", "nehqsfopdapxqlab", "fbtyzlmqekwisbah", "nqpqxehlcimpelha",
                "tfqfsvbwhwrichjx", "kzqscjcztadwjejl", "jjijrbdlwbrjpwkw", "vwcaayyzhwcfnnmx", "zjkhsytflegwjkkp",
                "dplwqojosauzafdm", "oqfozatkblhrgtfi", "glfmqehnombtfgbg", "czabawvpcpydwoon", "hvmznnpicdvdzdyy",
                "kclyliwllsvibzlk", "nftyancrxobdbfjx", "alzjewkdbzxqcaix", "yfancgrvzrnzmuzj", "gpypzuibdddqbloy",
                "xibvzvvnolzrvpyq", "pitgmjtutfsnxnzq", "czufnnhramkfpkbm", "kzxwgwbahhdhuytx", "hqwoltpnuhpcqzok",
                "wumeihirikhbyikb", "tfpjwcjfzyerzjfc", "fbmmxuvqfvaykzsa", "wtnnkjvzekgdhuff", "xbwctjaxedowxems",
                "ioaaspgjiofmoqbn", "ohlhsvcdkzzuribl", "guktsqvpryrdqzga", "chemfkrzyqembfej", "lcusyleynlmnppib",
                "qvzoheeewlnqgble", "qdcgdeowgfmbrqdg", "htmaxzyvhhzgkmgj", "chfmaakdcmdisblk", "ghyyniziyomygcpb",
                "euawkihcitbjgkft", "bwnhzvhngqgtelxx", "qqvzvipnpnxwjdmh", "rnuqcolrntmmomsp", "kbgdgqrtrdkyzosx",
                "ixgsakrqjrkvfdlt", "kjhrdhnvvyaxzetl", "yrrojhxuwjyavgjk", "cesdsugrjhpxsaii", "xffsukdgcvilpqfh",
                "ancdzbybotxcpzac", "qjizmxkoqahnvxgg", "hphxgaxdljcerorm", "jzbdjctqsmfdigih", "doaiyylxeuomnhdp",
                "keolfwsgcseojukl", "arjmppsyylqexsmw", "brqkiottwhoiqcgd", "hcxgdpswyylulrul", "hzulljnybiokqepq",
                "lpqyuzwbcbntdyee", "qcmgkcgeqmincyyw", "ogvrkvcxpffcpinj", "oascdubsabtlvdmn", "prcgsvfvszrssgie",
                "uegcagrmffwcelmw", "qtjjswzpiojupncy", "lserouxcyqehosiq", "jgltxtcpezgrtdgf", "hjtatgbdvfesnaig",
                "axrnrhprfqrwiktm", "aogkespeqwukqert", "larxhqesfuoyltgu", "fpcqlckdutivwtkq", "ybubxarenanvzjgr",
                "woswqevbyhfpqiso", "zfcrwwpiorpteufs", "amifyqrslrdouixd", "nmmibyijjcpelmqs", "boflnieugsqmcnhv",
                "enyowtrftynimjen", "kdlufutmobarilwd", "ztebyjzpmyjdbyrg", "yyjxtlmuyqeitktq", "oajufmkauerezlsr",
                "mvukjpbipmqstfxn", "kuqeiudhyiljpfpt", "pryfblvlkyvpezsm", "fidsjsfjufhpaphb", "fzekfqsuwdtquedn",
                "lkpnroglpgzzoybu", "innbafxvbytlsigm", "tmwtfujmmvjewdzh", "rmfinvjrqhpsnxhd", "doxujrxhzkzobwmj",
                "cioucshndcoqztap", "ovxjjipqjssxroxu", "qviosuedrcewtjtl", "fepzyaeszkydushx", "afejocxcstudgaeq",
                "gfjirksxxuzcptkg", "gnwpcxzkuiygfuly", "ouzqwnofqqkxszsp", "klzvwgocpetqdugl", "oqwyutucnbcaaxju",
                "gugxzdgiiobrexha", "xsucijhduodsjchk", "hnelnardrbldrbud", "plghaapqbfvvsdti", "rzuuqwrxqcqiwacg",
                "miulftkqwzmqwjoh", "nrznnvhkemqgkgsv", "mrkonrvwgoalymqk", "jqmxyblxbzpxpkbj", "rhqpahrhaeciwixb",
                "dfcubemuxeusnavg", "ysnbvnykgwjmhzsw", "scxumdiofeylxoyv", "ouhpzdchtugixgjv", "rrtlphgzqpycvywu",
                "cgotqwsaeupidlrv", "jncamcnzcxlyyjxr", "vsakgcymrtvrqscc", "enbenlumtbciuury", "oheynbmnigspazsp",
                "lmkvfxtofexvtgwg", "wlewrzzfxycmrbpx", "vguwcdvwipuqazob", "yksktdynhitagmpg", "svzruilehenkvfia",
                "pzlnrwmudphjslbn", "jpummgetjasepymb", "vxmfjkrzlohtdpwr", "xguibwhpoexuohdx", "qjunlphmxdoyiryg",
                "zezoqukwfpunpvas", "oqkjoxtimqpqgvhk", "skvpwsiqndmioijf", "feurthvdmgbrsdof", "rhvyqdohbcrjyfgc",
                "wfextoqgurlidolc", "hrtghbpwclgckwul", "sgevgruxaubafxxu", "mblchtvvgkelrdgc", "cujeayqrsobatezc",
                "dvtnssdpbwiibwgk", "segfwjurrpvypqhy", "mdnlbkmktgartjsa", "hrjblfvhwuwkaimf", "yppjqpcynukdyxms",
                "ggkggyjgnmjwnulw", "bixyknzirpjtbsmh", "nwoewhxwxqcyvbdk", "apacykmfikgasfnt", "qudntrnzpjjstlvd",
                "aapyeicnnjayzpsx", "hizvlnkcxlfdskzl", "wbpdshkxbgrcrtuy", "qyxrjwgdwafqyjja", "shdxgkohqusmtxyj",
                "guiibrenwlwdfqdu", "zrnyjgjxhmfhrxnz", "zuangeanwpbrlbfo", "fdymwqknctlwfaba", "dlkmklltaayemlft",
                "yyysdolfabylsjrg", "gmiibamodgytuiuf", "isyoyymrhbrdjhpn", "wrtfabspemlumtgx", "dvjuwwfwmpiupgck",
                "nebbtjvdnjalxhsl", "tcxzbutpqofeylqz", "tsdqdpnapokuseex", "zwunfqyxzmxmrrsf", "xzsifvaxkcszeizb",
                "joxubjzwefssesgw", "hiieivjqhnkcnyno", "mohyaqoxpxinphhi", "bkvflxhhrmvxhzdw", "pbepdlkmtouummtw",
                "anzvhlsofhioqgin", "dquevxvzkkkqcinz", "kekxlgvposiptxvj", "gcbthdcmkrvuyzdl", "hoknyusetkzotukx",
                "yvmtlcslgqddbvss", "wexlzaeiulovhpmg", "tupzatgxfmvuhjpi", "kaauifmbtjysfrll", "llzqpjbkbweyzsrg",
                "satcdfjqpdfxspin", "nnwiyjnjevophnyr", "wnunpxcdtirvhdox", "uruituzetnmwhrnh", "hcmiobabscioptog",
                "mfdmmdgcmpmrdliw", "deejoflzvlktixvm", "ejtdbaqztpkdopss", "ofoftpbqyzfvkonu", "dunlzvfgjumynokk",
                "egqszmsmriiwvjer", "nofkywrqjcdvxxku", "mvoyvtbpygmkbdcu", "afianivkzwjnwkci", "sgrejmqqgpqdjppg",
                "brthsiugiznwdmdy", "tlrojibptbanjitw", "akokdarsnmottxmh", "bzdgpcfeidqgkgbe", "xvzpvrribefsxpql",
                "rgxhimpyxkwcfsjv", "cggayworxwjqyiub", "cmgzthvdrylcpnbk", "gsmxjnesizgcsekp", "akwwjehnqfuyocyf",
                "axhvzkohbfgmtwdy", "mpyjkvfcswhgzvpk", "pyyzavmxfbjrxkjp", "dckouvaboaemzsen", "ufoobfwtgglkiejr",
                "ihhsucogdfyqsyxi", "xtlqoakdccwftbwh", "hqylfbwzshvmqosn", "glnwsyqmlepquhkc", "mczbursxycktfnuw",
                "alahgczbaamdcqwj", "tbwosedfdoqsvjtq", "cbdcfyiahwipsecd", "ducrktddpqxjzpxg", "wklvpwvitdjsewvd",
                "drzlmxkmpgdylokv", "taqdfookiilzkiro", "mdffhfhuybenkcev", "yrymkwdusmnywllh", "jcyimhirgojwaoxm",
                "kafauauqkotoqjiy", "xiialniocdyfzafz", "owsrrupnnaydwtxl", "xkeouczeqqlchlgc", "hntwpcscciwsgygj",
                "owpcumbgyvjvfhtd", "ktlsodliwlzwcibg", "nnldarmumhwycnmh", "nuerkodfikshltex", "tffseksbnlnxesio",
                "rjbdhjvzugiktweq", "gnzdvnbhygyghpwu", "bnfrpvbjclzmywzs", "kmwgvkdqpouwyess", "arbewnglfhvtmvsb",
                "qdolszesjymaplah", "bxztrreifjcufeoh", "mzwcodwpnsxnuuyq", "wazfzajcncxdzfbj", "rlanqzxkdmairfdc",
                "sofxpdfcnliidmmk", "hsqfijtkdtuaqgyo", "kwnbgcdjiexvbzdn", "wgsxamvqwwuifzix", "jgbxyfsvbxzqxsgb",
                "vuwfygtglcnvxzsk", "honyknsswnjcptwb", "icjauzxupjwwhwpj", "vlovlanrqwcmlamd", "krlwkpmwtntartvx",
                "vsrtgppgbjjlxfrc", "yieuhkezfjvfkpmv", "ukaqifssnvwdjeoy", "epclonsnnbarsqnd", "ctysmruhtaoacsac",
                "gnibyypurvnidiwt", "qscakllhmgsbfpre", "sbetrfmxghzkxrtp", "vleowjsgbedgfmzq", "erzilcxdivctcora",
                "hyjhfxtlufkmwvgr", "vraqzndefvdtxitm", "pgyfnrfodtdqhmbp", "xlkxpaeeozpjyrit", "duleiczxmbsucghn",
                "qqwwlhvfabfnusog", "klxmgipnwcpokpnd", "vlqmoqjlgzjmxmbg", "lehcgamxsyimgqth", "ikiqdgdazrlnuvhp",
                "eyvaunsgpbvwzglq", "kxljlaflhctkhwmo", "froggfbsizuulkfx", "ysojldfnjquxkuby", "nubgsezgeaqgykuh",
                "qtxehkitspyuiwgv", "ggwwrtinpnhaiisd", "bwdajoxpyhoccnqx", "rzskcnwzcpdkblds", "qyteswscuyowqppg",
                "ebqhnhnuaghorrvk", "cfmrramffdrutfzi", "knzyqqufxnwsdrhu", "poberjevqgkyjumv", "ysmecwxntijlizbk",
                "hlvfvpvjktmckjfd", "vsloukblhjsnmgkq", "iiakujirkwctpgdr", "lpubmtozuxpjmwgf", "kuewhaleowcaynxy",
                "zjlqaifjrdfadgrl", "tnzctlowmlgawrxm", "qacfsvqhefepwiem", "hmjubfyxupxpzdvg", "xcqhjsomlbumwjtu",
                "tpehxtytrlckjvlq", "ngxutcbaefvyliqa", "ftvfutqmnfzbjink", "pgoeccaudnbsqscj", "awwjurtrykdrjtbc",
                "ynezhnnhonpuuzva", "rgtqcghgvchoaogt", "patrurplbggnwhlv", "tjhzftdmeaiywmln", "mreypefpylkgexpv",
                "gksehpkxnwefkrco", "jtvyzkruooxbjqfm", "bpsgfhshuwkqxrwb", "yvmntgnflmbktjlf", "pmljczrbipccxjdi",
                "qfnqzrrvbympedkv", "akeupscuobqbcfqw", "gnskawfxgrtuftdc", "hauvfnycukkppdqd", "bixufwlszzajqlzz",
                "tmrjqbqwyuphyaie", "fnhhbtzbbwbfhxko", "mvkiaeceziuslmxt", "ojrxkjfbsxlerjsl", "zhgpnnshnsnqshwn",
                "yuwogfvyssztuloq", "irbffueunbwnzwtx", "iyskpivuxakcbfhv", "atbagdawcyzntljd", "qmujlsftooaozbpn",
                "qzrjavjstbuabwhi", "jutwslhqcqrzeczc", "vwrmhpwceqfxephu", "zfnoqqppnhfmfhbv", "wljgjvzdsiniavkg",
                "btybpkhywlzkjykt", "cejyxdptihlsktcb", "vcyswfrlnhzmtaia", "hmzhjhacjnllowxy", "qpvjntisszalfntz",
                "ykbdsaziuesycane", "bljxpmilmubcfwqs", "itrbplovomeuskzf", "bqnkulgxmynpyxzd", "leigzrqyfatimwec",
                "ptqcirqrythumuwi", "dptobuaagzwoituq", "tphtvjbzxqxfzuka", "ptvpuptkchbviezm", "rnhxmifuogzemuup",
                "ohoolneyupjuwqor", "gjmqofdevpixojun", "enpqftzcgdhwelkf", "ciceygubpdhqfniy", "apynsbnunnoxlfdq",
                "nbwxqqumaexnykid", "rntcwdpesdiykkez", "gjpzwlskzbxetzww", "xxrhuizgdzaxaoex", "autxzglluesrnrwy",
                "kdairicuvymwwoyr", "zrutddzwctgbumzk", "obkybawixnyuxzzt", "amdjsfkdmifanznp", "cnehljlsqpfzhozb",
                "vkqcewwgphgqepgt", "tvcdgxtgtlsupzmp", "jwfmxvzyifmrivob", "udlrkmhctvhisner", "hqbrzvfjcjrhzvwk",
                "cqvbcpzevrlfbnih", "qkiyxmyfbhoconwz", "ueeinaivkijmwxdi", "rfojlquphhyepcif", "ksyauyzhzvhmlvie",
                "pnhgrezabtxbskvc", "pptkzarzlpwbaitt", "ddigohzcjjuxqyeg", "jvrfhqydfvwzazed", "erarrgzaumixgqni",
                "qjyorxvtmpiqxpfx", "hboztgknncqhzkjo", "npzxloqhgqxlqhdg", "rnsexjucgwcrggrw", "ujimkhuqdzlocgbe",
                "aovfwupcyxjgrluy", "gizxxxcyrlgdgdgo", "zlvngmkudkjtzobe", "oxctscxhejhlzzyz", "qmgomhclqrnlfhty",
                "mdsznhefbtqhyzsl", "flvbzwnmzmqluuzk", "bbnncfvxhgptphbz", "oomyoauhctekkmsn", "tgenginnsfhiltun",
                "pkqjqqwssefivxga", "mfyknvlpozwtrtaz", "ggousvzylejekzpg", "nfaqstxgdizlanmh", "vylsuuxqbohshpkt",
                "acrhvqbhhugqtsze", "tiwmevmkqhejrkuc", "cflnrqkxqladfvyw", "wjgaclkmxfexjesk", "bpbkbmclnbcpijix",
                "inrbjyahiyticikc", "cjfqshgdotgannhp", "cxzvhwnpkpghkmtl", "ofkpswfmbbineefh", "rvlmoaewtmempzgk",
                "wkyrlimewvlnmuqu", "guzfbrsiyiqzgrqo", "phhtrsbnukxzkfet", "lxcgvolbyulhihls", "wfpyacjadzrcwkpd",
                "wejorrxxzbzjmyth", "lbadematolnxdzze", "jklbupheqamxwwsy", "pjvvudugzxnwipdx", "dpwunokcrtdpjtyg",
                "pvdurwfbwrqdsglw", "kmsjczauiavoqykt", "lizayqgnambdedtk", "lwgfgdwfzgtvxqdu", "afugcswefvebvqvr",
                "lxdixbbynshjzjoh", "gssaoznpbzupodrp", "rznjfxsedejtzgpz", "rtfamilihwujtmpo", "vomszawakyieztbb",
                "bclrpuyirnbxvaww", "tqpdutueqrzugfzf", "drwykkfyrtndcugd", "wvtvatfysdxdgwiv", "iavsfyhjuuchvemw",
                "kmqrqxkypgrtwdzm", "pbfkxoipenmhhpof", "cadlonvebfoeromt", "qyjxdkqbrvppappl", "zfxsqunbovtxwmri",
                "xopkbsnbtgohjjxa", "ohdhkkmvblvvgytm", "sifxuziiktmjibyr", "kimebzazlyuolwjj", "jmgfevlvmlojrtcs",
                "cgqplojfqcuphmro", "vtwdrnbhitlyfvnh", "zwmzrizzwtzkdesq", "phobtkxspwmlwxmx", "engdobejtugfryco",
                "qkzphzqvsdnylzvy", "jcyhhsdurkndwcly", "ydzhixgjawtaovoa", "fwbezynpdfwvdhyj", "rqvryysermyxdrcb",
                "dkcdsmptftqyownb", "ttddstlnsslzqibg", "hzvqbnxdiswcstxn", "gbfhljqomjrymgtg", "uvovxphnyqpjdtxg",
                "nthcaxfbjkoccgkc", "bdbtscfsdtnhdrfv", "jqpjqxqqqcxfzatk", "umshzxnxjnqejraw", "qxhrnqbrksjezdlt",
                "bmknwtszowqdkyhc", "pphohnzexssageht", "telkyzynxqyngoke", "sokkljbfnipodald", "euteauvdosuynftk",
                "jztabxhknbyipqps", "hcdgldgjfuswpvay", "cqzyvqyamporjavs", "tziqowtnllljesfm", "vpmmnpwitelbfwxm",
                "bqhuxffqalfwmgbr", "hfpzjxubcqqdzuqw", "hleetncbghqsgqwa", "rvlslwomfojdqyyd", "yffmhaeplliuhjuj",
                "gcvohjswjyztvohl", "wrlkwvkqiiwldeyn", "inlhxetlftfjouxk", "tjyfczuzclettniu", "jcmqpohakfjgrrax",
                "akawchgqvqnfuyvq", "sugnviybbsqzebtu", "gzzzysjongrfoeen", "azssjkgjbrfmvgsx", "rmpqulwllffxsnfj",
                "rgoyofrggblrmbyp", "nwzvyngclzlfkgwf", "kummjpbxqhdkeqyz", "mswfdekujajvxafv", "nefdpiscmbvjnlti",
                "uyauwvsuhbtfojdd", "kjamhqbvrrbjliho", "kqaurcbbmyywuiab", "kfbyzxxmwrdwthig", "iohwqwbifvmkuyxj",
                "vnskhfsawdnmdyyx", "mkwfizqreudyhqmb", "izityyuklaymdqmb", "pozwltgwxanbocsn", "hjwdicoltaglfmhl",
                "ilbvkhpioihyujxy", "yfdnkhzttwrytoww", "pzdhrqsdbiwiomzg", "jdwbvgeinblpockt", "vcmknnxqbixynfrh",
                "ntqcqkgcckixbikw", "kojiapomujowmdrd", "hiaopdrosfoqxacw", "gvujlbdedvczwwgh", "lxnxjtlfntbevzmz",
                "rlddsiuqlrvvctiv", "vecnhsmlxalbfcff", "yfrcupjpvtwyhacz", "uuzbzycrsizwplfo", "hnwceunfkiimtyse",
                "ysiiagivwwwhczin", "mixkqqtituipkujn", "jhosvnmikftikmyq", "uosgnkbknjlsxdyc", "qvuaxcipxlgopbmh",
                "fqtpyoujxfsapksi", "plekjstfgxhrddgv", "cydxunbwuqyumhlh", "lgkuhghruliwxkfi", "jihfylbrwsvhkalp",
                "jratkunajghtbxyq", "vutuzmtzfqhekccb", "qkfhhjsidlrgpotf", "tznorhrnoghalsqr", "qqbwsmaysjkwaaqe",
                "mleluhndzztpnbfq", "gbcgpyaiugevmwyw", "zkkyvbpnvfbnsofq", "krzwepruljnsqgpv", "isvzdewwotrtuzlo",
                "ffeonobupfyjexhw", "xobwrewjuzswgiun", "gjfrgmfubwwrewwx", "igcfvwlrhwklfnah", "fusoxhgcfviaefml",
                "anwjityxvxtlusln", "xbiztfwmkulmtark", "ftfrrunusghhnyeq", "wfqyagcrfxhlgves", "skdirtgtnydandxo",
                "jcskdfsfmkjotvqf", "aqrcnpqcfzqhadgd", "oiduysjqedcodqza", "cmhwcbjujgaljvwt", "dbgszrmgqbyvtkpq",
                "gtqsaynvzarreuul", "wsuvznrcdjlbmkxt", "typfsxzpwbttjjox", "hsnawuxmjwxmeyiq", "zkxzbnsbpyqlfiwh",
                "zkipqwlefcovmzmu", "dddtqlxmbjzvrxiv", "ajgusqbvgnrzygbt", "horrensepxqpyryl", "jkpeaktozibbaywl",
                "jgyaveybwapjgwip", "oughftbvlwyciahg", "dlaequtgwkihyhvb", "qdiffxfpiugqnoos", "jbahtlawzestkyth",
                "roxqeyfgjlsrnicd", "hcbxyfpeubhodred", "ufyjgasabxtkfhnc", "vcxigxzxycxeovpz", "cokurkkegebaqwfx",
                "mdmsbchaavotddkm", "foepivugdhcmnkgr", "orzagckhrrfgsnpo", "pxnbttptnqdtmzie", "wrjizbkckmvofbgs",
                "voqefcisvdfcbytp", "vwtrcxvauqxcrksi", "siagsweegmiykqen", "izrhqjbninpwarmr", "xivrzppxxweltsvg",
                "hvcebfnapiaksfca", "govczulyzvsfsmpj", "dzhwmcrdgjkmvuvx", "zaksfepynunjbmqq", "iehrvggqbvaeapjh",
                "kanuzjwpopcqgbak", "bhaeheazjxcqglqm", "iqmpdwcfuuyosgyn", "qiauizabgkibyxzj", "scofrygvxnqsqbea",
                "bpcvvblowfgifwie", "xfmnehxkizrlnsqf", "pwlvotcmaorvlcwp", "bmudhqrbxbvtwkya", "kxvirkeqxdtkwvwx",
                "avgvcivemxpohcmk", "ylzmhhrpdmuoswie", "kvtjzksmqrxwpwzg", "ecwjsgoplxtacjzc", "wfgkozseluftpfed",
                "rllaqpeibhztvlfa", "ohqdtpgeepkpihjb", "cvvvoenyssxxqrdh", "kzxiwhzrqrdyqwmz", "ykpdovivwjmtrnpf",
                "nkkqpgvejmayvgsz", "ijlhlwrfdhawiovi", "nxuhoboamzjxobia", "ckleiknfrzkdhjzm", "dxdznhkrinlvvhxx",
                "bizxqckimejfulej", "arfcjgkqarvsoxkd", "rdnnuqlevjphqgzz", "rofxqvltumknbymj", "qzwhhmjhksypxrrv",
                "tuoyuhnypnqnyadt", "shzzgvdudwjazhew", "rnalnzrfwvgtdlfm", "afrkxpqlnehkeqdw", "qtrsuorzelbnbrze",
                "khnnqybdnpfxsply", "bvrmxeaeamhxhqzs", "fjxctyzmlatnmqoz", "lonxqpxrfgkstnfd", "zfyybvfwwxprvbdt",
                "ymjnseyckdyjtviv", "xapsigwznlqgnikf", "djdjzlmkwqqmlowd", "fqkcngawjuuwiutx", "hpyaasplrcdzthdj",
                "vevzbfamiaiatucg", "peoblkupcnaptzio", "hootfkxumcixaeak", "nzdldcltzlxiwyor", "fzimqlyhahdrgalp",
                "mhqddrvfttatcjbs", "gvcysxobgwswdixh", "zoaiwxniwjjhinpa", "orgrfgndwodijuna", "fzdezinzowvylrll",
                "kblfmbbbnzvkequi", "rzvzyhjfllfsnvco", "afphivobxylgntff", "nvuglcddusrwqlrv", "lteldiqxzxwsnqfw",
                "lhvsxfkktlktdvpg", "xijltanucofgplbj" }));
    }

    public static int longestStrChain(String[] words) {
        words = sort(words);

        int[] wordChainSize = new int[words.length];
        int longest = 0;
        int i = 1;
        int beforeI = 0;
        while (i < words.length) {
            if (words[i].length() != words[beforeI].length() + 1) {
                if (i - 1 == beforeI) {
                    beforeI = i;
                } else {
                    beforeI = i - 1;
                    continue;
                }
            } else {
                int p = beforeI;
                do {
                    if (isPredecessor(words[p], words[i])) {
                        wordChainSize[i] = Math.max(wordChainSize[i], wordChainSize[p] + 1);
                    }
                    p--;
                } while (p >= 0 && words[p].length() + 1 == words[i].length());

                longest = Math.max(longest, wordChainSize[i]);
            }
            i++;
        }
        return longest + 1;
    }

    private static boolean isPredecessor(String word1, String word2) {
        int wl1 = word1.length();
        int wl2 = word2.length();

        if (wl1 + 1 != wl2) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;

        while (p1 < wl1 && p2 < wl2) {
            if (word1.charAt(p1) == word2.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == wl1 && (p2 == wl2 || p2 == wl1);
    }

    private static String[] sort(String[] words) {
        int[] indexes = new int[16];
        String[] wordsCopy = new String[words.length];
        for (String word : words) {
            indexes[word.length() - 1]++;
        }

        for (int i = 1; i < indexes.length; i++) {
            indexes[i] += indexes[i - 1];
        }

        for (String word : words) {
            wordsCopy[--indexes[word.length() - 1]] = word;
        }

        return wordsCopy;
    }
}
