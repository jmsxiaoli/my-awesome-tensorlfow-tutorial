load("//tensorflow:tensorflow.bzl", "pytype_strict_binary")
load("//tensorflow:tensorflow.bzl", "tf_cc_binary")
load("//tensorflow/compiler/mlir/quantization/tensorflow:internal_visibility_allowlist.bzl", "internal_visibility_allowlist")
load("@llvm-project//mlir:tblgen.bzl", "gentbl_cc_library", "td_library")

package_group(
    name = "internal_visibility_allowlist_package",
    packages = [
        "//tensorflow/compiler/mlir/quantization/...",
    ] + internal_visibility_allowlist(),
)

package(
    default_visibility = [
        ":internal_visibility_allowlist_package",
    ],
    licenses = ["notice"],
)

pytype_strict_binary(
    name = "gen_quantized_function_library",
    srcs = ["gen_quantized_function_library.py"],
    deps = [
        "@absl_py//absl:app",
        "@absl_py//absl/flags",
    ],
)

genrule(
    name = "quantized_function_library",
    srcs = ["passes/quantized_function_library.mlir"],
    outs = [
        "passes/quantized_function_library.h",
    ],
    cmd = "$(location gen_quantized_function_library) --output_file $(RULEDIR)/passes/quantized_function_library.h --src $(SRCS)",
    exec_tools = ["gen_quantized_function_library"],
)

cc_library(
    name = "pass_util",
    srcs = [
        "passes/util.cc",
    ],
    hdrs = [
        "passes/util.h",
    ],
    deps = [
        "//tensorflow/compiler/mlir/lite/quantization:quantization_lib",
        "@llvm-project//mlir:IR",
        "@llvm-project//mlir:QuantOps",
        "@llvm-project//mlir:StandardOps",
    ],
)

td_library(
    name = "ptq_td_files",
    srcs = [
        "passes/lift_quantizable_spots_as_functions.td",
        "passes/prepare_quantize.td",
        "passes/quantize_composite_functions.td",
        "passes/utils.td",
    ],
    deps = [
        "//tensorflow/compiler/mlir/lite:tensorflow_lite_ops_td_files",
        "//tensorflow/compiler/mlir/tensorflow:tensorflow_ops_td_files",
        "@llvm-project//mlir:ArithmeticOpsTdFiles",
        "@llvm-project//mlir:StdOpsTdFiles",
    ],
)

gentbl_cc_library(
    name = "lift_quantizable_spots_as_functions_inc_gen",
    tbl_outs = [
        (
            ["-gen-rewriters"],
            "passes/lift_quantizable_spots_as_functions.inc",
        ),
    ],
    tblgen = "@llvm-project//mlir:mlir-tblgen",
    td_file = "passes/lift_quantizable_spots_as_functions.td",
    deps = [":ptq_td_files"],
)

gentbl_cc_library(
    name = "prepare_quantize_inc_gen",
    tbl_outs = [
        (
            ["-gen-rewriters"],
            "passes/prepare_quantize.inc",
        ),
    ],
    tblgen = "@llvm-project//mlir:mlir-tblgen",
    td_file = "passes/prepare_quantize.td",
    deps = [":ptq_td_files"],
)

gentbl_cc_library(
    name = "quantize_composite_functions_inc_gen",
    tbl_outs = [
        (
            ["-gen-rewriters"],
            "passes/quantize_composite_functions.inc",
        ),
    ],
    tblgen = "@llvm-project//mlir:mlir-tblgen",
    td_file = "passes/quantize_composite_functions.td",
    deps = [":ptq_td_files"],
)

cc_library(
    name = "passes",
    srcs = [
        "passes/convert_custom_aggregation_op_to_quant_stats.cc",
        "passes/convert_fake_quant_to_qdq.cc",
        "passes/insert_custom_aggregation_ops.cc",
        "passes/insert_main_function.cc",
        "passes/insert_quantized_functions.cc",
        "passes/issue_ids_of_custom_aggregation_ops.cc",
        "passes/lift_quantizable_spots_as_functions.cc",
        "passes/lift_quantizable_spots_as_functions.inc",
        "passes/post_quantize.cc",
        "passes/prepare_quantize.cc",
        "passes/prepare_quantize.inc",
        "passes/quantize.cc",
        "passes/quantize_composite_functions.cc",
        "passes/quantize_composite_functions.inc",
        "passes/quantized_function_library.h",
    ],
    hdrs = [
        "passes/passes.h",
    ],
    deps = [
        ":pass_util",
        "//tensorflow/compiler/mlir/lite:tensorflow_lite",
        "//tensorflow/compiler/mlir/lite/quantization:quantization_config",
        "//tensorflow/compiler/mlir/lite/quantization:quantization_lib",
        "//tensorflow/compiler/mlir/quantization/tensorflow/utils:fake_quant_utils",
        "//tensorflow/compiler/mlir/tensorflow",
        "//tensorflow/compiler/mlir/tensorflow:tensorflow_ops",
        "//tensorflow/core:framework",
        "//tensorflow/core/platform:env",
        "//tensorflow/core/platform:macros",
        "//tensorflow/core/platform:path",
        "//tensorflow/lite/kernels/internal:quantization_util",
        "@com_google_absl//absl/container:flat_hash_set",
        "@com_google_absl//absl/random",
        "@com_google_absl//absl/strings",
        "@llvm-project//llvm:Support",
        "@llvm-project//mlir:IR",
        "@llvm-project//mlir:Parser",
        "@llvm-project//mlir:Pass",
        "@llvm-project//mlir:QuantOps",
        "@llvm-project//mlir:StandardOps",
        "@llvm-project//mlir:Support",
        "@llvm-project//mlir:TransformUtils",
    ],
    alwayslink = 1,
)

tf_cc_binary(
    name = "tf-quant-opt",
    srcs = ["passes/tf_quant_opt.cc"],
    deps = [
        ":passes",
        "//tensorflow/compiler/mlir:init_mlir",
        "//tensorflow/compiler/mlir/tensorflow",
        "//tensorflow/compiler/mlir/tensorflow:tensorflow_passes",
        "//tensorflow/compiler/mlir/tensorflow:tf_dialect_passes",
        "@llvm-project//mlir:AllPassesAndDialects",
        "@llvm-project//mlir:MlirOptLib",
        "@llvm-project//mlir:QuantOps",
        "@llvm-project//mlir:SCFDialect",
        "@llvm-project//mlir:Shape",
        "@llvm-project//mlir:StandardOps",
    ],
)
