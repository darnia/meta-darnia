DESCRIPTION="U-boot configured for sunxi devices"

require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native bison-native"
DEPENDS_append_sun50i = " atf-sunxi "

LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "\
file://Licenses/Exceptions;md5=338a7cb1e52d0d1951f83e15319a3fe7 \
file://Licenses/bsd-2-clause.txt;md5=6a31f076f5773aabd8ff86191ad6fdd5 \
file://Licenses/bsd-3-clause.txt;md5=4a1190eac56a9db675d58ebe86eaf50c \
file://Licenses/eCos-2.0.txt;md5=b338cb12196b5175acd3aa63b0a0805c \
file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
file://Licenses/ibm-pibs.txt;md5=c49502a55e35e0a8a1dc271d944d6dba \
file://Licenses/isc.txt;md5=ec65f921308235311f34b79d844587eb \
file://Licenses/lgpl-2.0.txt;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
file://Licenses/lgpl-2.1.txt;md5=4fbd65380cdd255951079008b364516c \
file://Licenses/x11.txt;md5=b46f176c847b8742db02126fb8af92e2 \
"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

SRC_URI = " \
  git://git.denx.de/u-boot.git;branch=master \
  file://boot.cmd \
  file://Add_Spi_Nor_Flash_Boot_Support.patch \
  file://Increase_Kernel_Image_Max_Size.patch \
  file://0001-dts-makefile.patch \
  file://sun50i-h6-tanix-tx6-mini.dts;subdir=git/arch/arm/dts/ \
  file://sun50i-h6-tanix-tx6.dts;subdir=git/arch/arm/dts/ \
  file://tx6_defconfig;subdir=git/configs/ \
  file://tx6m_defconfig;subdir=git/configs/ \
"
#  file://0001-sunxi-h3-Fix-PLL1-setup-to-never-use-dividers.patch 

SRCREV = "0b0c6af38738f2c132cfd41a240889acaa031c8f"

PV = "v2020.01"

S = "${WORKDIR}/git"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

EXTRA_OEMAKE += ' HOSTLDSHARED="${BUILD_CC} -shared ${BUILD_LDFLAGS} ${BUILD_CFLAGS}" '
EXTRA_OEMAKE_append_sun50i = " BL31=${DEPLOY_DIR_IMAGE}/bl31.bin "

do_compile_sun50i[depends] += "atf-sunxi:do_deploy"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
