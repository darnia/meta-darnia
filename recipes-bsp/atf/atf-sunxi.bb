inherit deploy

DESCRIPTION = "ARM Trusted Firmware"
LICENSE = "BSD"
#LIC_FILES_CHKSUM = "file://license.rst;md5=c709b197e22b81ede21109dbffd5f363"
LIC_FILES_CHKSUM = "file://license.rst;md5=1dd070c98a281d18d9eefd938729b031"

FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI = " \
        git://github.com/ARM-software/arm-trusted-firmware.git;nobranch=1 \
        file://0001-Fix-reset-issue-on-H6-by-using-R_WDOG.patch \
        "
#SRCREV = "eaea119ea12d20837d3ada880621ac0a895f98eb"
SRCREV = "a04808c16cfc126d9fe572ae7c4b5a3d39de5796"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

COMPATIBLE_MACHINE = "(sun50i)"

# Fix this.. support for A64 and H5 needs platform = sun50i_a64
PLATFORM_sun50i = "sun50i_h6"

LDFLAGS[unexport] = "1"

do_compile() {
    oe_runmake -C ${S} BUILD_BASE=${B} \
      CROSS_COMPILE=${TARGET_PREFIX} \
      PLAT=${PLATFORM} \
      bl31 \
      all
}

do_deploy() {
    install -D -p -m 0644 ${B}/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/bl31.bin
}

addtask deploy after do_compile

