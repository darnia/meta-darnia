require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

LINUX_VERSION = "5.4"
LINUX_VERSION_EXTENSION = "-darnia"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"

PV = "5.4.14"
SRCREV = "0fce94b45b53c9fb1657a94f3419a67b61e0344c"


SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    	file://defconfig \
	file://0010-media-v4l2-add_CID_UNIT_CELL_SIZE-control.patch \
	file://0011-media-v4l2-add_CTRL_TYPE_AREA-control-type.patch \
	file://0012-media-v4l2-add-definitions-for-HEVC-stateless-decoding.patch \
	file://0013-media-v4l2-add-mem2mem-support-held-capture-buffers.patch \
	file://0014-media-v4l2-add-mem2mem-add-stateless_try_decoder_cmd-ioctl.patch \
	file://0015-media-v4l2-add-mem2mem-add-new_frame-detection.patch \
	file://0016-media-v4l2-add-V4L2_BUF_FLAG_M2M_HOLD_CAPTURE_BUF.patch \
	file://0017-media-v4l2-videodev2.h-add-V4L2_DEC_CMD_FLUSH.patch \
	file://0018-media-v4l2-add-mem2mem-Fix-hold-buf-flag-checks.patch \
	file://0019-media-uapi-h264-Add-DPB-entry-field-reference-flags.patch \
	file://0020-media-v4l2-mem2mem-mark-DONE-any-OUTPUT-queued-buffer-after-CMD_STOP-v2.patch \
	file://0102-WIP-drm-panfrost-add-support-for-custom-soft-reset-on-GXM.patch \
	file://0350-drm-dw-hdmi-call-hdmi_set_cts_n-after-clock-is-.patch \
	file://0351-fix-chmap_idx.patch \
	file://0352-ASoC-hdmi-codec-reorder-channel-allocation-list.patch \
	file://0353-multi-channel-GX-audio-hack.patch \
	file://0520-phy-allwinner-add-phy-driver-for-USB3-PHY-on-Allwinn.patch \
	file://0521-arm64-allwinner-dts-h6-add-USB3-device-nodes.patch \
	file://0524-mmc-sunxi-fix-unusuable-eMMC-on-some-H6-boards-by-disabling-DDR.patch \
	file://0525-arm64-allwinner-dts-h6-add-Mali-GPU-for-H6-boards.patch \
	file://0526-pwm-sun4i-Add-support-for-Allwinner-H6.patch \
	file://0527-bus-sunxi-rsb-Make-interrupt-handling-more-robust.patch \
	file://0528-arm64-dts-allwinner-add-rgmii-pins-for-some-h6-boards.patch \
	file://0529-arm64-dts-allwinner-add-Tanix-TX6.patch \
	file://0532-dt-bindings-Add-compatible-for-H6-RTC.patch \
	file://0533-allwinner-h6-add-AC200-EPHY-support.patch \
	file://0534-arm64-dts-sun50i-h6-add-AC200-nodes.patch \
	file://0535-drm-sun4i-Mark-one-of-the-UI-planes-as-a-cursor-one.patch \
	file://0536-drm-sun8i-ui-vi-Fix-layer-zpos-change-atomic-modesetting.patch \
	file://0550-thermal-sun8i-add-thermal-driver-for-A64-H3-H5-H6.patch \
	file://0551-thermal-sun8i-add-dts-nodes.patch \
	file://0552-thermal-sun8i-enable-ths-in-h6-boards.patch \
	file://0553-arm64-dts-allwinner-h6-Add-clock-to-CPU-cores.patch \
	file://0554-arm64-dts-allwinner-h6-Add-CPU-OPP-table.patch \
	file://0555-arm64-dts-allwinner-h6-enable-dvfs-fix-CPU-voltage-some-boards.patch \
	file://0560-clk-sunxi-ng-h6-Use-sigma-delta-modulation-for-audio-PLL.patch \
	file://0561-clk-sunxi-ng-h6-Allow-GPU-to-change-parent-rate.patch \
	file://0564-ARM-dts-sunxi-h3-h5-Add-DAI-node-for-HDMI.patch \
	file://0565-arm64-dts-allwinner-a64-Add-DAI-node-for-HDMI.patch \
	file://0566-ARM-dts-sunxi-h3-h5-Add-HDMI-audio.patch \
	file://0567-ARM-sun8i-h3-Add-HDMI-audio-to-Orange-Pi-2.patch \
	file://0569-ARM-dts-sun50i-a64-Add-I2S0-pins-to-dtsi.patch \
	file://0570-arm64-dts-sun50i-a64-Add-HDMI-audio-to-A64-DTSI.patch \
	file://0571-arm64-dts-sun50i-a64-Add-HDMI-audio-to-Pine64.patch \
	file://0572-arm64-dts-sun50i-h6-Add-HDMI-audio-to-H6-DTSI.patch \
	file://0573-arm64-dts-allwinner-orange-pi-Enable-HDMI-output.patch \
	file://0574-ASoC-sun4i-i2s-Move-channel-select-offset.patch \
	file://0575-ASoC-sun4i-i2s-Add-functions-for-RX-and-TX-channel-o.patch \
	file://0576-ASoC-sun4i-i2s-Add-functions-for-RX-and-TX-channel-e.patch \
	file://0577-ASoC-sun4i-i2s-Add-functions-for-RX-and-TX-channel-s.patch \
	file://0578-ASoC-sun4i-i2s-Add-functions-for-RX-and-TX-channel-m.patch \
	file://0579-dt-bindings-ASoC-sun4i-i2s-Add-H6-compatible.patch \
	file://0580-ASoC-sun4i-i2s-Add-support-for-H6-I2S.patch \
	file://0581-ASoC-sun4i-i2s-Add-function-to-sign-extend-sample.patch \
	file://0582-ASoC-sun4i-i2s-Adjust-LRCLK-width.patch \
	file://0583-ASoc-sun4i-i2s-Add-20-and-24-bit-support.patch \
	file://0584-ASoC-sun4i-i2s-Add-multi-lane-functionality.patch \
	file://0585-ASoC-sun4i-i2s-Add-multichannel-functionality.patch \
	file://0586-ASoC-sun4i-i2s-Adjust-regmap-settings.patch \
	file://0588-arm64-dts-allwinner-Add-SPDIF-node-for-Allwinner-H6.patch \
	file://0590-arm64.dts-sun50i-h6-add-gpu.patch \
	file://0607-media-cedrus-choose-default-pixelformat-in-try_fmt.patch \
	file://0608-media-cedrus-fix-various-format-related-compliance-issues.patch \
	file://0609-media-cedrus-h264-Support-multiple-slices-per-frame.patch \
	file://0611-media-cedrus-Remove-unnecessary-parenthesis-aroundDIV_ROUND_UP.patch \
	file://0612-media-cedrus-Add-HEVC-decoding-support.patch \
	file://0615-media-cedrus-Fix-decoding-for-some-H264-videos.patch \
	file://0619-media-cedrus-Properly-signa-size-in-mode-register.patch \
	file://0620-media-cedrus-Fix-H264-4k-support.patch \
	file://0621-media-cedrus-Increase-maximum-supported-size.patch \
	file://0622-media-cedrus-improvements.patch \
	file://0623-media-cedrus-10bit-HEVC-hack.patch \
"
#	file://0617-media-cedrus-Use-correct-H264-8x8-scaling-list.patch 

SRC_URI_append_tx6m = "file://sun50i-h6-tanix-tx6-mini.dts;subdir=git/arch/arm64/boot/dts/allwinner"
KERNEL_DEVICETREE_tx6m += " allwinner/sun50i-h6-tanix-tx6-mini.dtb" 

SRC_URI_append_opi0 = "file://0001-dts-orange-pi-zero-Add-wifi-support.patch"
SRC_URI_append_opi-r1 = "file://0001-r8152b-led.patch"
SRC_URI_append_bpi-m2-zero = "file://0001-dts-sun8i-h2-plus-bananapi-m2-zero.patch"
