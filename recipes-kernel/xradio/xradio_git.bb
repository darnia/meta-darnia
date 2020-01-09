SUMMARY = "Xradio WiFi driver for orangepi-zero"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

inherit module

RDEPENDS_${PN} += "xradio-firmware"

COMPATIBLE_MACHINE = "(opi0)"

PV = "git${SRCPV}"

SRCREV = "aa01ba77b9360dd734b50f5b937960a50c5a0825"

SRC_URI = "git://github.com/fifteenhex/xradio.git;protocol=https \
           file://Add_Targets_To_Makefile.patch \
           file://0001-remain-channel.patch \
          "

S = "${WORKDIR}/git"

KERNEL_MODULE_AUTOLOAD += "xradio_wlan"
