SUMMARY = "Realtek out-of-tree kernel driver for rtl8189fs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://include/autoconf.h;startline=1;endline=18;md5=34511ed52d7f1cb5362a143cc96f1185"

inherit module

PV = "git${SRCPV}"

SRC_URI = "git://github.com/jwrdegoede/rtl8189ES_linux.git;branch=master \
	file://0001-Add-module-install.patch \
	"
SRCREV = "28d84253471f5f8f39e3e70955e577c1085d7c30"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    CONFIG_RTL8189FS=m \
    KSRC=${STAGING_KERNEL_DIR} \
    "
KERNEL_MODULE_AUTOLOAD += "8189fs"
