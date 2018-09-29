<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction" xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc" xmlns:ns0="http://shrikworld.blogspot.in/response" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20" xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions" xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator" xmlns:oracle-xsl-mapper="http://www.oracle.com/xsl/mapper/schemas" xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue" xmlns:oraxsl="http://www.oracle.com/XSL/Transform/java" xmlns:tns="http://xmlns.oracle.com/singleString" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" exclude-result-prefixes=" xsd oracle-xsl-mapper xsi xsl ns0 tns mhdr oraext xp20 xref socket dvm oraxsl"
                xmlns:stat="http://www.oracle.com/XSL/Transform/java/soa.cookbook.xpath.StdDev" xml:id="id_1"
                oraxsl:ignorexmlids="true">
   <oracle-xsl-mapper:schema xml:id="id_2">
      <!--SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY.-->
      <oracle-xsl-mapper:mapSources xml:id="id_3">
         <oracle-xsl-mapper:source type="XSD" xml:id="id_4">
            <oracle-xsl-mapper:schema location="../Schemas/respuesta.xsd" xml:id="id_5"/>
            <oracle-xsl-mapper:rootElement name="Response" namespace="http://shrikworld.blogspot.in/response"
                                           xml:id="id_6"/>
         </oracle-xsl-mapper:source>
      </oracle-xsl-mapper:mapSources>
      <oracle-xsl-mapper:mapTargets xml:id="id_7">
         <oracle-xsl-mapper:target type="XSD" xml:id="id_8">
            <oracle-xsl-mapper:schema location="../Schemas/dummy.xsd" xml:id="id_9"/>
            <oracle-xsl-mapper:rootElement name="input" namespace="http://xmlns.oracle.com/singleString"
                                           xml:id="id_10"/>
         </oracle-xsl-mapper:target>
      </oracle-xsl-mapper:mapTargets>
      <!--GENERATED BY ORACLE XSL MAPPER 12.2.1.3.0(XSLT Build 170820.1700.2557) AT [FRI SEP 21 16:49:28 CEST 2018].-->
   </oracle-xsl-mapper:schema>
   <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
   <xsl:template match="/" xml:id="id_11">
        <xsl:variable name="temp" xml:id="id_12">
            <xsl:value-of select="/ns0:Response/ns0:Code" xml:id="id_13"/>
        </xsl:variable>
        <xsl:variable name="var1" select="socket:socketWrite($temp, '','')" xml:id="id_14"/>
        <xsl:variable name="var2" select="socket:socketEndOutput()" xml:id="id_15"/>
   </xsl:template>
</xsl:stylesheet>
