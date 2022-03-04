// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/framework/model.proto

package org.tensorflow.proto.data.model;

public final class ModelProtos {
  private ModelProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_data_model_ModelProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_data_model_ModelProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_data_model_ModelProto_Node_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_data_model_ModelProto_Node_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_data_model_ModelProto_Node_Parameter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_data_model_ModelProto_Node_Parameter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_data_model_ModelProto_NodesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_data_model_ModelProto_NodesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_data_model_ModelProto_OptimizationParams_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_data_model_ModelProto_OptimizationParams_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n%tensorflow/core/framework/model.proto\022" +
      "\025tensorflow.data.model\"\364\007\n\nModelProto\022;\n" +
      "\005nodes\030\001 \003(\0132,.tensorflow.data.model.Mod" +
      "elProto.NodesEntry\022\016\n\006output\030\002 \001(\003\022\022\n\nid" +
      "_counter\030\003 \001(\003\022Q\n\023optimization_params\030\005 " +
      "\001(\01324.tensorflow.data.model.ModelProto.O" +
      "ptimizationParams\032\277\004\n\004Node\022\n\n\002id\030\001 \001(\003\022\014" +
      "\n\004name\030\002 \001(\t\022\020\n\010autotune\030\003 \001(\010\022\026\n\016buffer" +
      "ed_bytes\030\004 \001(\003\022\031\n\021buffered_elements\030\005 \001(" +
      "\003\022\026\n\016bytes_consumed\030\006 \001(\003\022\026\n\016bytes_produ" +
      "ced\030\007 \001(\003\022\024\n\014num_elements\030\010 \001(\003\022\027\n\017proce" +
      "ssing_time\030\t \001(\003\022\026\n\016record_metrics\030\n \001(\010" +
      "\022D\n\nparameters\030\013 \003(\01320.tensorflow.data.m" +
      "odel.ModelProto.Node.Parameter\022!\n\031input_" +
      "processing_time_sum\030\014 \001(\001\022#\n\033input_proce" +
      "ssing_time_count\030\r \001(\003\022\016\n\006inputs\030\016 \003(\003\0224" +
      "\n\nnode_class\030\017 \001(\0162 .tensorflow.data.mod" +
      "el.NodeClass\022\r\n\005ratio\030\020 \001(\001\022\024\n\014memory_ra" +
      "tio\030\021 \001(\001\032h\n\tParameter\022\014\n\004name\030\001 \001(\t\022\r\n\005" +
      "value\030\002 \001(\001\022\023\n\013state_value\030\003 \001(\001\022\013\n\003min\030" +
      "\004 \001(\001\022\013\n\003max\030\005 \001(\001\022\017\n\007tunable\030\006 \001(\010\032T\n\nN" +
      "odesEntry\022\013\n\003key\030\001 \001(\003\0225\n\005value\030\002 \001(\0132&." +
      "tensorflow.data.model.ModelProto.Node:\0028" +
      "\001\032\223\001\n\022OptimizationParams\022;\n\talgorithm\030\001 " +
      "\001(\0162(.tensorflow.data.model.AutotuneAlgo" +
      "rithm\022\022\n\ncpu_budget\030\002 \001(\003\022\022\n\nram_budget\030" +
      "\003 \001(\003\022\030\n\020model_input_time\030\004 \001(\001J\004\010\004\020\005*\203\001" +
      "\n\tNodeClass\022\013\n\007UNKNOWN\020\000\022\023\n\017INTERLEAVE_M" +
      "ANY\020\001\022\031\n\025ASYNC_INTERLEAVE_MANY\020\002\022\017\n\013KNOW" +
      "N_RATIO\020\003\022\025\n\021ASYNC_KNOWN_RATIO\020\004\022\021\n\rUNKN" +
      "OWN_RATIO\020\005*9\n\021AutotuneAlgorithm\022\016\n\nHILL" +
      "_CLIMB\020\000\022\024\n\020GRADIENT_DESCENT\020\001B\201\001\n\037org.t" +
      "ensorflow.proto.data.modelB\013ModelProtosP" +
      "\001ZLgithub.com/tensorflow/tensorflow/tens" +
      "orflow/go/core/framework/model_go_proto\370" +
      "\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tensorflow_data_model_ModelProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tensorflow_data_model_ModelProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_data_model_ModelProto_descriptor,
        new java.lang.String[] { "Nodes", "Output", "IdCounter", "OptimizationParams", });
    internal_static_tensorflow_data_model_ModelProto_Node_descriptor =
      internal_static_tensorflow_data_model_ModelProto_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_data_model_ModelProto_Node_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_data_model_ModelProto_Node_descriptor,
        new java.lang.String[] { "Id", "Name", "Autotune", "BufferedBytes", "BufferedElements", "BytesConsumed", "BytesProduced", "NumElements", "ProcessingTime", "RecordMetrics", "Parameters", "InputProcessingTimeSum", "InputProcessingTimeCount", "Inputs", "NodeClass", "Ratio", "MemoryRatio", });
    internal_static_tensorflow_data_model_ModelProto_Node_Parameter_descriptor =
      internal_static_tensorflow_data_model_ModelProto_Node_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_data_model_ModelProto_Node_Parameter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_data_model_ModelProto_Node_Parameter_descriptor,
        new java.lang.String[] { "Name", "Value", "StateValue", "Min", "Max", "Tunable", });
    internal_static_tensorflow_data_model_ModelProto_NodesEntry_descriptor =
      internal_static_tensorflow_data_model_ModelProto_descriptor.getNestedTypes().get(1);
    internal_static_tensorflow_data_model_ModelProto_NodesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_data_model_ModelProto_NodesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_tensorflow_data_model_ModelProto_OptimizationParams_descriptor =
      internal_static_tensorflow_data_model_ModelProto_descriptor.getNestedTypes().get(2);
    internal_static_tensorflow_data_model_ModelProto_OptimizationParams_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_data_model_ModelProto_OptimizationParams_descriptor,
        new java.lang.String[] { "Algorithm", "CpuBudget", "RamBudget", "ModelInputTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}