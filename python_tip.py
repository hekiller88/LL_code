# 格式输出, HH:MM:SS
def make_readable(s):
    return "{:02}:{:02}:{:02}".format(int(s / 3600), int(s / 60 % 60), s % 60)
