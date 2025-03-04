# Description:
#   Contains experimental kernels for datasets and iterators.

load(
    "//tensorflow:tensorflow.bzl",
    "if_not_mobile",
    "tf_cc_test",
)
load("//tensorflow:tensorflow.bzl", "tf_kernel_library")  # buildifier: disable=same-origin-load
load("//tensorflow:tensorflow.bzl", "filegroup")  # buildifier: disable=same-origin-load

package(
    default_visibility = ["//tensorflow:internal"],
    licenses = ["notice"],
)

filegroup(
    name = "portable_all_op_kernels_headers",
    srcs = [
        "threadpool_dataset_op.h",
    ],
    visibility = ["//tensorflow:__subpackages__"],
)

# A file group which contains all operators which are known to work on mobile.
filegroup(
    name = "portable_all_op_kernels",
    srcs = [
        "lookup_ops.cc",
        "take_while_dataset_op.cc",
        "threadpool_dataset_op.cc",
        ":portable_all_op_kernels_headers",
    ],
    visibility = ["//tensorflow:__subpackages__"],
)

tf_kernel_library(
    name = "assert_cardinality_dataset_op",
    srcs = ["assert_cardinality_dataset_op.cc"],
    hdrs = ["assert_cardinality_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core/data:name_utils",
    ],
)

tf_kernel_library(
    name = "assert_next_dataset_op",
    srcs = ["assert_next_dataset_op.cc"],
    hdrs = ["assert_next_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
    ],
)

tf_cc_test(
    name = "assert_next_dataset_op_test",
    size = "small",
    srcs = ["assert_next_dataset_op_test.cc"],
    deps = [
        ":assert_next_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:test_main",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/kernels/data:range_dataset_op",
        "//tensorflow/core/kernels/data:take_dataset_op",
    ],
)

tf_kernel_library(
    name = "auto_shard_dataset_op",
    srcs = ["auto_shard_dataset_op.cc"],
    hdrs = ["auto_shard_dataset_op.h"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:rewrite_utils",
        "//tensorflow/core/grappler/optimizers/data:auto_shard",
    ],
)

tf_cc_test(
    name = "auto_shard_dataset_op_test",
    size = "small",
    srcs = ["auto_shard_dataset_op_test.cc"],
    deps = [
        ":auto_shard_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/kernels/data:range_dataset_op",
        "//tensorflow/core/kernels/data:shard_dataset_op",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    name = "choose_fastest_branch_dataset_op",
    srcs = ["choose_fastest_branch_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/kernels/data:take_dataset_op",
    ],
)

tf_kernel_library(
    name = "choose_fastest_dataset_op",
    srcs = ["choose_fastest_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
    ],
)

tf_kernel_library(
    name = "compression_ops",
    srcs = ["compression_ops.cc"],
    hdrs = ["compression_ops.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:compression_utils",
        "//tensorflow/core/data:dataset_proto_cc",
    ],
)

tf_kernel_library(
    name = "compute_batch_size_op",
    srcs = ["compute_batch_size_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:serialization_utils",
        "//tensorflow/core/grappler:graph_view",
        "//tensorflow/core/grappler/optimizers/data:graph_utils",
        "//tensorflow/core/platform:regexp",
    ],
)

tf_kernel_library(
    name = "csv_dataset_op",
    srcs = ["csv_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
    ],
)

tf_kernel_library(
    name = "data_service_dataset_op",
    srcs = ["data_service_dataset_op.cc"],
    hdrs = ["data_service_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:framework_internal",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_proto_cc",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:serialization_utils",
        "//tensorflow/core/data/service:common",
        "//tensorflow/core/data/service:common_proto_cc",
        "//tensorflow/core/data/service:dispatcher_client",
        "//tensorflow/core/data/service:dispatcher_proto_cc",
        "//tensorflow/core/data/service:grpc_util",
        "//tensorflow/core/data/service:worker_client",
        "//tensorflow/core/data/service:worker_impl",
        "//tensorflow/core/data/service:worker_proto_cc",
        "//tensorflow/core/distributed_runtime/rpc:grpc_util",
        "//tensorflow/core/kernels/data:parallel_map_dataset_op",
        "//tensorflow/core/platform:env_time",
        "//tensorflow/core/platform:errors",
        "//tensorflow/core/platform:mutex",
        "//tensorflow/core/platform:refcount",
        "//tensorflow/core/platform:status",
        "//tensorflow/core/platform:statusor",
        "//tensorflow/core/platform:thread_annotations",
        "//tensorflow/core/platform:tstring",
        "//tensorflow/core/platform:types",
        "//tensorflow/core/profiler/lib:traceme",
        "//tensorflow/core/profiler/lib:traceme_encode",
        "@com_google_absl//absl/algorithm:container",
        "@com_google_absl//absl/container:flat_hash_map",
        "@com_google_absl//absl/container:flat_hash_set",
        "@com_google_absl//absl/strings",
        "@com_google_absl//absl/time",
    ],
)

tf_kernel_library(
    name = "data_service_ops",
    srcs = ["data_service_ops.cc"],
    hdrs = ["data_service_ops.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:serialization_utils",
        "//tensorflow/core/data/service:common_proto_cc",
        "//tensorflow/core/data/service:dispatcher_client",
        "//tensorflow/core/data/service:grpc_util",
        "//tensorflow/core/framework:graph_proto_cc",
        "//tensorflow/core/kernels/data:iterator_ops",
    ],
)

tf_kernel_library(
    name = "dense_to_sparse_batch_dataset_op",
    srcs = ["dense_to_sparse_batch_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
    ],
)

tf_kernel_library(
    name = "directed_interleave_dataset_op",
    srcs = ["directed_interleave_dataset_op.cc"],
    hdrs = ["directed_interleave_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:split_utils",
        "//third_party/eigen3",
    ],
)

tf_cc_test(
    name = "directed_interleave_dataset_op_test",
    size = "small",
    srcs = ["directed_interleave_dataset_op_test.cc"],
    deps = [
        ":directed_interleave_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/kernels/data:range_dataset_op",
        "//tensorflow/core/kernels/data:tensor_slice_dataset_op",
    ],
)

tf_kernel_library(
    name = "group_by_reducer_dataset_op",
    srcs = ["group_by_reducer_dataset_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
    ],
)

tf_kernel_library(
    name = "group_by_window_dataset_op",
    srcs = ["group_by_window_dataset_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/kernels/data:window_dataset",
    ],
)

tf_kernel_library(
    name = "ignore_errors_dataset_op",
    srcs = ["ignore_errors_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core/platform:logging",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    name = "io_ops",
    srcs = ["io_ops.cc"],
    hdrs = ["io_ops.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:framework_internal",
        "//tensorflow/core:lib",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:hash_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:root_dataset",
        "//tensorflow/core/data:snapshot_utils",
        "//tensorflow/core/framework:op_requires",
        "//tensorflow/core/kernels/data:iterator_ops",
    ],
)

tf_cc_test(
    name = "io_ops_test",
    size = "small",
    srcs = ["io_ops_test.cc"],
    deps = [
        ":io_ops",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:serialization_utils",
        "//tensorflow/core/framework:function_testlib",
        "//tensorflow/core/framework:types_proto_cc",
        "//tensorflow/core/kernels:cwise_op",
        "//tensorflow/core/kernels:function_ops",
        "//tensorflow/core/kernels/data:range_dataset_op",
    ],
)

tf_kernel_library(
    name = "lmdb_dataset_op",
    srcs = ["lmdb_dataset_op.cc"],
    hdrs = ["lmdb_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//third_party/eigen3",
        "@lmdb",
    ],
)

tf_cc_test(
    name = "lmdb_dataset_op_test",
    size = "small",
    srcs = ["lmdb_dataset_op_test.cc"],
    data = ["//tensorflow/core/lib/lmdb:lmdb_testdata"],
    deps = [
        ":lmdb_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/platform:env",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    name = "lookup_ops",
    srcs = ["lookup_ops.cc"],
    deps = [
        "//tensorflow/core:core_cpu",
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:framework",
        "//tensorflow/core:framework_internal",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:root_dataset",
        "//tensorflow/core/kernels:function_ops",
        "//tensorflow/core/kernels:initializable_lookup_table",
        "//tensorflow/core/kernels:lookup_util",
        "//third_party/eigen3",
        "@com_google_absl//absl/strings",
    ],
)

tf_kernel_library(
    name = "map_and_batch_dataset_op",
    srcs = ["map_and_batch_dataset_op.cc"],
    hdrs = ["map_and_batch_dataset_op.h"],
    deps = [
        "//tensorflow/core:array_ops_op_lib",
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:framework_internal",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:nn_ops_op_lib",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:stats_utils",
        "//tensorflow/core/kernels:inplace_ops",
        "//tensorflow/core/profiler/lib:traceme",
        "//tensorflow/core/profiler/lib:traceme_encode",
    ],
)

tf_cc_test(
    name = "map_and_batch_dataset_op_test",
    size = "small",
    srcs = ["map_and_batch_dataset_op_test.cc"],
    deps = [
        ":map_and_batch_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/kernels:cwise_op",
        "//tensorflow/core/kernels/data:range_dataset_op",
    ],
)

tf_kernel_library(
    name = "matching_files_dataset_op",
    srcs = ["matching_files_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
    ],
)

tf_kernel_library(
    name = "non_serializable_dataset_op",
    srcs = ["non_serializable_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    name = "parallel_interleave_dataset_op",
    srcs = ["parallel_interleave_dataset_op.cc"],
    hdrs = ["parallel_interleave_dataset_op.h"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/profiler/lib:traceme",
        "//tensorflow/core/profiler/lib:traceme_encode",
    ],
)

tf_cc_test(
    name = "parallel_interleave_dataset_op_test",
    size = "small",
    srcs = ["parallel_interleave_dataset_op_test.cc"],
    deps = [
        ":parallel_interleave_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/kernels/data:tensor_slice_dataset_op",
    ],
)

tf_kernel_library(
    name = "parse_example_dataset_op",
    srcs = ["parse_example_dataset_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:framework",
        "//tensorflow/core:functional_ops_op_lib",
        "//tensorflow/core:lib",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:stats_utils",
        "//tensorflow/core/kernels:ragged_tensor_variant",
        "//tensorflow/core/kernels/data:parallel_map_dataset_op",
        "//tensorflow/core/profiler/lib:traceme",
        "//tensorflow/core/profiler/lib:traceme_encode",
    ],
)

tf_kernel_library(
    name = "prefetching_kernels",
    srcs = ["prefetching_kernels.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
    ],
)

tf_kernel_library(
    name = "random_access_ops",
    srcs = ["random_access_ops.cc"],
    hdrs = ["random_access_ops.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:framework_internal",
        "//tensorflow/core:lib",
        "//tensorflow/core/data:finalization_utils",
        "//tensorflow/core/kernels/data:iterator_ops",
        "//tensorflow/core/platform",
    ],
)

tf_kernel_library(
    name = "random_dataset_op",
    srcs = ["random_dataset_op.cc"],
    hdrs = ["random_dataset_op.h"],
    deps = [
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:split_utils",
    ],
)

tf_cc_test(
    name = "random_dataset_op_test",
    size = "small",
    srcs = ["random_dataset_op_test.cc"],
    deps = [
        ":random_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    name = "rebatch_dataset_op",
    srcs = ["rebatch_dataset_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:name_utils",
    ],
)

tf_kernel_library(
    name = "sampling_dataset_op",
    srcs = ["sampling_dataset_op.cc"],
    hdrs = ["sampling_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:name_utils",
    ],
)

tf_cc_test(
    name = "sampling_dataset_op_test",
    size = "small",
    srcs = ["sampling_dataset_op_test.cc"],
    deps = [
        ":sampling_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/kernels/data:range_dataset_op",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    name = "scan_dataset_op",
    srcs = ["scan_dataset_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
    ],
)

tf_kernel_library(
    name = "set_stats_aggregator_dataset_op",
    srcs = ["set_stats_aggregator_dataset_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:stats_utils",
    ],
)

tf_kernel_library(
    name = "sleep_dataset_op",
    srcs = ["sleep_dataset_op.cc"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core/data:dataset_utils",
    ],
)

tf_kernel_library(
    name = "sliding_window_dataset_op",
    srcs = ["sliding_window_dataset_op.cc"],
    deps = [
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
    ],
)

tf_kernel_library(
    name = "snapshot_dataset_op",
    srcs = ["snapshot_dataset_op.cc"],
    hdrs = ["snapshot_dataset_op.h"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:hash_utils",
        "//tensorflow/core/data:name_utils",
        "//tensorflow/core/data:serialization_utils",
        "//tensorflow/core/data:snapshot_utils",
        "//tensorflow/core/framework:op_requires",
        "//tensorflow/core/platform:platform_port",
        "//tensorflow/core/profiler/lib:traceme",
        "@com_google_absl//absl/container:flat_hash_map",
        "@com_google_absl//absl/strings",
        "@com_google_absl//absl/time",
    ],
)

tf_kernel_library(
    name = "sql_dataset_op",
    srcs = [
        "sql_dataset_op.cc",
    ],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/kernels/data/experimental/sql",
    ],
)

tf_kernel_library(
    name = "stats_aggregator_ops",
    srcs = ["stats_aggregator_ops.cc"],
    deps = [
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
        "//tensorflow/core/kernels:summary_interface",
    ],
)

tf_kernel_library(
    name = "stats_dataset_ops",
    srcs = ["stats_dataset_ops.cc"],
    deps = [
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:protos_all_cc",
    ],
)

tf_kernel_library(
    name = "take_while_dataset_op",
    srcs = ["take_while_dataset_op.cc"],
    deps = [
        "//tensorflow/core:core_cpu_internal",
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:captured_function",
        "//tensorflow/core/data:dataset_utils",
    ],
)

tf_kernel_library(
    name = "threadpool_dataset_op",
    srcs = ["threadpool_dataset_op.cc"],
    hdrs = ["threadpool_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:dataset_utils",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    name = "to_tf_record_op",
    srcs = ["to_tf_record_op.cc"],
    deps = [
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:dataset_utils",
        "//tensorflow/core/data:root_dataset",
        "//tensorflow/core/kernels:ops_util",
    ],
)

tf_kernel_library(
    name = "unbatch_dataset_op",
    srcs = ["unbatch_dataset_op.cc"],
    deps = [
        "//tensorflow/core:dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core/data:dataset_utils",
    ],
)

tf_kernel_library(
    name = "unique_dataset_op",
    srcs = ["unique_dataset_op.cc"],
    hdrs = ["unique_dataset_op.h"],
    deps = [
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//third_party/eigen3",
    ],
)

tf_cc_test(
    name = "unique_dataset_op_test",
    size = "small",
    srcs = ["unique_dataset_op_test.cc"],
    deps = [
        ":unique_dataset_op",
        "//tensorflow/core:experimental_dataset_ops_op_lib",
        "//tensorflow/core:framework",
        "//tensorflow/core:lib",
        "//tensorflow/core:lib_internal",
        "//tensorflow/core:test",
        "//tensorflow/core:test_main",
        "//tensorflow/core:testlib",
        "//tensorflow/core/data:dataset_test_base",
        "//tensorflow/core/kernels/data:tensor_slice_dataset_op",
        "//third_party/eigen3",
    ],
)

tf_kernel_library(
    # data service kernels depend on GRPC, so we package them separately
    # so that downstream rules can avoid depending on GRPC.
    name = "data_service_kernels",
    deps = [
        ":data_service_dataset_op",
        ":data_service_ops",
    ],
)

tf_kernel_library(
    name = "experimental",
    deps = [
        ":assert_cardinality_dataset_op",
        ":assert_next_dataset_op",
        ":choose_fastest_branch_dataset_op",
        ":choose_fastest_dataset_op",
        ":compression_ops",
        ":csv_dataset_op",
        ":dense_to_sparse_batch_dataset_op",
        ":directed_interleave_dataset_op",
        ":group_by_reducer_dataset_op",
        ":group_by_window_dataset_op",
        ":ignore_errors_dataset_op",
        ":io_ops",
        ":map_and_batch_dataset_op",
        ":matching_files_dataset_op",
        ":non_serializable_dataset_op",
        ":lookup_ops",
        ":parallel_interleave_dataset_op",
        ":parse_example_dataset_op",
        ":prefetching_kernels",
        ":random_access_ops",
        ":random_dataset_op",
        ":rebatch_dataset_op",
        ":sampling_dataset_op",
        ":scan_dataset_op",
        ":set_stats_aggregator_dataset_op",
        ":sleep_dataset_op",
        ":sliding_window_dataset_op",
        ":snapshot_dataset_op",
        ":sql_dataset_op",
        ":stats_aggregator_ops",
        ":stats_dataset_ops",
        ":take_while_dataset_op",
        ":threadpool_dataset_op",
        ":to_tf_record_op",
        ":unbatch_dataset_op",
        ":unique_dataset_op",
    ] + select({
        "//tensorflow:fuchsia": [],
        "//conditions:default": [":lmdb_dataset_op"],
    }) + if_not_mobile([
        # auto_shard_dataset_op uses RewriteDataset method, which
        # is not defined on mobile platforms
        ":auto_shard_dataset_op",
        # compute_batch_size_op depends on grappler, which
        # should not be included on mobile platforms
        ":compute_batch_size_op",
    ]),
)
