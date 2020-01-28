# Distribution definition for: darnia

# Distro config is evaluated after the machine config, so we have to explicitly
# set the kernel provider to override a machine config.
PREFERRED_PROVIDER_virtual/kernel ?= "linux-stable"
PREFERRED_VERSION_linux-stable ?= "5.4%"

# Comment out any of the lines below to disable them in the build
# DISTRO_FEATURES options:
# alsa bluetooth ext2 pcmcia usbgadget usbhost wifi nfs zeroconf pci
DISTRO_FEATURES_GENERAL = "ext2 pci systemd"
DISTRO_FEATURES_NET = "ipv4 ipv6"
DISTRO_FEATURES_USB = "usbhost"
DISTRO_FEATURES_USBGADGET = "usbgadget"
DISTRO_FEATURES_WIFI = "wifi"
DISTRO_FEATURES_WIRED = "wired"
#DISTRO_FEATURES_BLUETOOTH = "bluetooth"

DISTRO_FEATURES = "${DISTRO_FEATURES_GENERAL} \
                   ${DISTRO_FEATURES_BLUETOOTH} \
                   ${DISTRO_FEATURES_NET} \
                   ${DISTRO_FEATURES_USB} \
                   ${DISTRO_FEATURES_USBGADGET} \
                   ${DISTRO_FEATURES_WIFI} \
                   ${DISTRO_FEATURES_WIRED} \
                   ${DISTRO_FEATURES_LIBC} \
                  "

# Enable LFS - see bug YOCTO #5865
DISTRO_FEATURES_append_libc-uclibc = " largefile"
DISTRO_FEATURES_append_libc-musl = " largefile"

DISTRO_FEATURES_class-native = "${DISTRO_FEATURES_DEFAULT} ${POKY_DEFAULT_DISTRO_FEATURES}"
DISTRO_FEATURES_class-nativesdk = "${DISTRO_FEATURES_DEFAULT} ${POKY_DEFAULT_DISTRO_FEATURES}"

# enable systemd for init
INIT_MANAGER ?= "systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

IMAGE_FSTYPES = "ext4"

QB_DEFAULT_FSTYPE = "${IMAGE_FSTYPES}"

#
#PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
#PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"

# Disable python usage in opkg-utils since it won't build with tiny config
PACKAGECONFIG_remove_pn-opkg-utils = "python"

# 
PACKAGECONFIG_remove_pn-systemd = " networkd timesyncd"

# 
PACKAGECONFIG_append_pn-coreutils = " \
    single-binary \
"

DISTRO_FEATURES_BACKFILL_CONSIDERED += "pulseaudio"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
