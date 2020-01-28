SOC_FAMILY ??= ""
include conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/kernel ?= "linux-stable"
PREFERRED_PROVIDER_u-boot ?= "u-boot-opi"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-opi"

KERNEL_IMAGETYPE ?= "Image"

IMAGE_FSTYPES += "ext4 tar.gz"

MACHINE_EXTRA_RRECOMMENDS = "kernel-modules"

UBOOT_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"

UBOOT_ENTRYPOINT ?= "0x40008000"
UBOOT_LOADADDRESS ?= "0x400080OB00"

UBOOT_BINARY = "u-boot.itb"
SPL_BINARY = "spl/sunxi-spl.bin"

SERIAL_CONSOLE ?= "115200 ttyS0"
MACHINE_FEATURES ?= "alsa apm keyboard rtc serial screen usbgadget usbhost vfat"
