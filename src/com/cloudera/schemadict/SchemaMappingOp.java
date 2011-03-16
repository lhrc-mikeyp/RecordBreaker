// (c) Copyright (2010) Cloudera, Inc.
package com.cloudera.schemadict;

/***************************************************
 * SchemaMappingOp describes a schema-modification step.
 *
 * @author mjc
 ***************************************************/
public class SchemaMappingOp { 
  public static int CREATE_OP = 1;
  public static int DELETE_OP = 2;
  public static int TRANSFORM_OP = 3;

  int opcode;
  SchemaStatisticalSummary s1;
  SchemaStatisticalSummary s2;
  int nodeid1;
  int nodeid2;

  /**
   */
  public SchemaMappingOp() {
  }
  public SchemaMappingOp(int opcode, SchemaStatisticalSummary s, int nodeid) {
    this.opcode = opcode;
    this.s1 = s;
    this.nodeid1 = nodeid;
  }
  public SchemaMappingOp(int opcode, SchemaStatisticalSummary s1, int nodeid1, SchemaStatisticalSummary s2, int nodeid2) {
    this.opcode = opcode;
    this.s1 = s1;
    this.nodeid1 = nodeid1;
    this.s2 = s2;
    this.nodeid2 = nodeid2;
  }
  public String getS1DatasetLabel() {
    return s1.getDatasetLabel();
  }
  public String getS1FieldLabel() {
    return s1.getLabel(nodeid1);
  }
  public String getS1FieldType() {
    return s1.getTypeDesc(nodeid1);
  }
  public String getS2DatasetLabel() {
    return s2.getDatasetLabel();
  }
  public String getS2FieldLabel() {
    return s2.getLabel(nodeid2);
  }
  public String getS2FieldType() {
    return s2.getTypeDesc(nodeid2);
  }
  public String toString() {
    if (opcode == CREATE_OP) {
      return "CREATE " + nodeid1 + "(" + s1.getDesc(nodeid1) + ")";
    } else if (opcode == DELETE_OP) {
      return "DELETE " + nodeid1 + "(" + s1.getDesc(nodeid1) + ")";
    } else if (opcode == TRANSFORM_OP) {
      return "TRANSFORM " + nodeid1 + " (" + s1.getDesc(nodeid1) + "," + nodeid1 + ")" + " => " + nodeid2 + " (" + s2.getDesc(nodeid2) + "," + nodeid2 + ")";
    } else {
      return "<unknown>";
    }
  }
}