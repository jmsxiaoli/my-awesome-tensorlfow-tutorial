load("//tensorboard/defs:defs.bzl", "tf_ng_module", "tf_sass_binary", "tf_sass_library", "tf_ts_library")

package(default_visibility = ["//tensorboard:internal"])

tf_sass_library(
    name = "metrics_common_styles",
    srcs = [
        "_common.scss",
    ],
)

tf_sass_binary(
    name = "metrics_container_styles",
    src = "metrics_container.scss",
    deps = ["//tensorboard/webapp:angular_material_sass_deps"],
)

tf_sass_binary(
    name = "metrics_promo_styles",
    src = "metrics_promo_notice_component.scss",
)

tf_ng_module(
    name = "views",
    srcs = [
        "metrics_container.ts",
        "metrics_promo_notice_component.ts",
        "metrics_promo_notice_container.ts",
        "metrics_promo_notice_types.ts",
        "metrics_views_module.ts",
    ],
    assets = [
        ":metrics_container_styles",
        ":metrics_promo_styles",
        "metrics_promo_notice_component.ng.html",
    ],
    deps = [
        "//tensorboard/webapp:app_state",
        "//tensorboard/webapp:selectors",
        "//tensorboard/webapp/angular:expect_angular_material_icon",
        "//tensorboard/webapp/core",
        "//tensorboard/webapp/customization",
        "//tensorboard/webapp/metrics/actions",
        "//tensorboard/webapp/metrics/views/main_view",
        "//tensorboard/webapp/metrics/views/right_pane",
        "//tensorboard/webapp/runs/views/runs_selector",
        "@npm//@angular/common",
        "@npm//@angular/core",
        "@npm//@ngrx/store",
        "@npm//rxjs",
    ],
)

tf_ts_library(
    name = "types",
    srcs = [
        "metrics_view_types.ts",
    ],
    deps = ["//tensorboard/webapp/metrics:types"],
)

tf_ts_library(
    name = "utils",
    srcs = [
        "utils.ts",
    ],
    deps = [
        ":types",
        "//tensorboard/webapp/util:types",
    ],
)

tf_ts_library(
    name = "views_test",
    testonly = True,
    srcs = [
        "metrics_container_test.ts",
        "utils_test.ts",
    ],
    deps = [
        ":types",
        ":utils",
        ":views",
        "//tensorboard/webapp:app_state",
        "//tensorboard/webapp:selectors",
        "//tensorboard/webapp/angular:expect_angular_core_testing",
        "//tensorboard/webapp/angular:expect_angular_platform_browser_animations",
        "//tensorboard/webapp/angular:expect_ngrx_store_testing",
        "//tensorboard/webapp/metrics/actions",
        "//tensorboard/webapp/metrics/data_source",
        "@npm//@angular/core",
        "@npm//@angular/platform-browser",
        "@npm//@ngrx/store",
        "@npm//@types/jasmine",
    ],
)
