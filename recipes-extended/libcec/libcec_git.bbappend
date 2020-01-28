# Use libcec version with kernel cec support
SRC_URI = "git://github.com/Kwiboo/libcec;protocol=https;branch=cec-framework"
SRCREV = "467cc79fd289403e7d4f6e4e817b906c0c0027dd"

EXTRA_OECMAKE += "-DHAVE_LINUX_API=1"
