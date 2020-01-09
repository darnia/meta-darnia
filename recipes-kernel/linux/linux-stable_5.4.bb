require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

LINUX_VERSION = "5.4"
LINUX_VERSION_EXTENSION = "-darnia"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"

PV = "5.4.6"
SRCREV = "957a16c3e6e19777865c2d629408d8b4396d6a4b"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
"

SRC_URI_append_opi0 += "file://0001-dts-orange-pi-zero-Add-wifi-support.patch"
SRC_URI_append_opi-r1 += "file://0001-r8152b-led.patch"
SRC_URI_append_bpi-m2-zero += "file://0001-dts-sun8i-h2-plus-bananapi-m2-zero.patch"
