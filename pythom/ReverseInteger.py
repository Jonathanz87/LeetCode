def reverse(self, x):
    """
    :type x: int
    :rtype: int
    """
    sign = 1
    if x < 0:
        sign = -1
        x = -x
    result = 0

    while x > 0:
        result = result * 10 + x % 10
        x = int(x / 10)

    if result > 2 ** 31 - 1 or result < -2 ** 31:
        return 0
    return result * sign