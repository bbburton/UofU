<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE eagle SYSTEM "eagle.dtd">
<eagle version="9.6.2">
<drawing>
<settings>
<setting alwaysvectorfont="no"/>
<setting verticaltext="up"/>
</settings>
<grid distance="0.1" unitdist="inch" unit="inch" style="lines" multiple="1" display="no" altdistance="0.01" altunitdist="inch" altunit="inch"/>
<layers>
<layer number="1" name="Top" color="4" fill="1" visible="no" active="no"/>
<layer number="16" name="Bottom" color="1" fill="1" visible="no" active="no"/>
<layer number="17" name="Pads" color="2" fill="1" visible="no" active="no"/>
<layer number="18" name="Vias" color="2" fill="1" visible="no" active="no"/>
<layer number="19" name="Unrouted" color="6" fill="1" visible="no" active="no"/>
<layer number="20" name="Dimension" color="15" fill="1" visible="no" active="no"/>
<layer number="21" name="tPlace" color="7" fill="9" visible="no" active="no"/>
<layer number="22" name="bPlace" color="7" fill="1" visible="no" active="no"/>
<layer number="23" name="tOrigins" color="7" fill="1" visible="no" active="no"/>
<layer number="24" name="bOrigins" color="15" fill="1" visible="no" active="no"/>
<layer number="25" name="tNames" color="7" fill="1" visible="no" active="no"/>
<layer number="26" name="bNames" color="7" fill="1" visible="no" active="no"/>
<layer number="27" name="tValues" color="7" fill="1" visible="no" active="no"/>
<layer number="28" name="bValues" color="7" fill="1" visible="no" active="no"/>
<layer number="29" name="tStop" color="7" fill="3" visible="no" active="no"/>
<layer number="30" name="bStop" color="7" fill="6" visible="no" active="no"/>
<layer number="31" name="tCream" color="7" fill="4" visible="no" active="no"/>
<layer number="32" name="bCream" color="7" fill="5" visible="no" active="no"/>
<layer number="33" name="tFinish" color="6" fill="3" visible="no" active="no"/>
<layer number="34" name="bFinish" color="6" fill="6" visible="no" active="no"/>
<layer number="35" name="tGlue" color="7" fill="4" visible="no" active="no"/>
<layer number="36" name="bGlue" color="7" fill="5" visible="no" active="no"/>
<layer number="37" name="tTest" color="7" fill="1" visible="no" active="no"/>
<layer number="38" name="bTest" color="7" fill="1" visible="no" active="no"/>
<layer number="39" name="tKeepout" color="4" fill="11" visible="no" active="no"/>
<layer number="40" name="bKeepout" color="1" fill="11" visible="no" active="no"/>
<layer number="41" name="tRestrict" color="4" fill="10" visible="no" active="no"/>
<layer number="42" name="bRestrict" color="1" fill="10" visible="no" active="no"/>
<layer number="43" name="vRestrict" color="2" fill="10" visible="no" active="no"/>
<layer number="44" name="Drills" color="7" fill="1" visible="no" active="no"/>
<layer number="45" name="Holes" color="7" fill="1" visible="no" active="no"/>
<layer number="46" name="Milling" color="3" fill="1" visible="no" active="no"/>
<layer number="47" name="Measures" color="5" fill="1" visible="no" active="no"/>
<layer number="48" name="Document" color="7" fill="1" visible="no" active="no"/>
<layer number="49" name="Reference" color="7" fill="1" visible="no" active="no"/>
<layer number="51" name="tDocu" color="6" fill="9" visible="no" active="no"/>
<layer number="52" name="bDocu" color="7" fill="1" visible="no" active="no"/>
<layer number="88" name="SimResults" color="9" fill="1" visible="yes" active="yes"/>
<layer number="89" name="SimProbes" color="9" fill="1" visible="yes" active="yes"/>
<layer number="90" name="Modules" color="5" fill="1" visible="yes" active="yes"/>
<layer number="91" name="Nets" color="2" fill="1" visible="yes" active="yes"/>
<layer number="92" name="Busses" color="1" fill="1" visible="yes" active="yes"/>
<layer number="93" name="Pins" color="2" fill="1" visible="no" active="yes"/>
<layer number="94" name="Symbols" color="4" fill="1" visible="yes" active="yes"/>
<layer number="95" name="Names" color="7" fill="1" visible="yes" active="yes"/>
<layer number="96" name="Values" color="7" fill="1" visible="yes" active="yes"/>
<layer number="97" name="Info" color="7" fill="1" visible="yes" active="yes"/>
<layer number="98" name="Guide" color="6" fill="1" visible="yes" active="yes"/>
</layers>
<schematic xreflabel="%F%N/%S.%C%R" xrefpart="/%S.%C%R">
<libraries>
<library name="led" urn="urn:adsk.eagle:library:259">
<description>&lt;b&gt;LEDs&lt;/b&gt;&lt;p&gt;
&lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;&lt;br&gt;
Extended by Federico Battaglin &lt;author&gt;&amp;lt;federico.rd@fdpinternational.com&amp;gt;&lt;/author&gt; with DUOLED</description>
<packages>
<package name="1206" urn="urn:adsk.eagle:footprint:15651/1" library_version="5">
<description>&lt;b&gt;CHICAGO MINIATURE LAMP, INC.&lt;/b&gt;&lt;p&gt;
7022X Series SMT LEDs 1206 Package Size</description>
<wire x1="1.55" y1="-0.75" x2="-1.55" y2="-0.75" width="0.1016" layer="51"/>
<wire x1="-1.55" y1="-0.75" x2="-1.55" y2="0.75" width="0.1016" layer="51"/>
<wire x1="-1.55" y1="0.75" x2="1.55" y2="0.75" width="0.1016" layer="51"/>
<wire x1="1.55" y1="0.75" x2="1.55" y2="-0.75" width="0.1016" layer="51"/>
<wire x1="-0.55" y1="-0.5" x2="0.55" y2="-0.5" width="0.1016" layer="21" curve="95.452622"/>
<wire x1="-0.55" y1="-0.5" x2="-0.55" y2="0.5" width="0.1016" layer="51" curve="-84.547378"/>
<wire x1="-0.55" y1="0.5" x2="0.55" y2="0.5" width="0.1016" layer="21" curve="-95.452622"/>
<wire x1="0.55" y1="0.5" x2="0.55" y2="-0.5" width="0.1016" layer="51" curve="-84.547378"/>
<smd name="A" x="-1.422" y="0" dx="1.6" dy="1.803" layer="1"/>
<smd name="C" x="1.422" y="0" dx="1.6" dy="1.803" layer="1"/>
<text x="-1.27" y="1.27" size="1.27" layer="25">&gt;NAME</text>
<text x="-1.27" y="-2.54" size="1.27" layer="27">&gt;VALUE</text>
<rectangle x1="-0.1" y1="-0.1" x2="0.1" y2="0.1" layer="21"/>
<rectangle x1="0.45" y1="-0.7" x2="0.8" y2="-0.45" layer="51"/>
<rectangle x1="0.8" y1="-0.7" x2="0.9" y2="0.5" layer="51"/>
<rectangle x1="0.8" y1="0.55" x2="0.9" y2="0.7" layer="51"/>
<rectangle x1="-0.9" y1="-0.7" x2="-0.8" y2="0.5" layer="51"/>
<rectangle x1="-0.9" y1="0.55" x2="-0.8" y2="0.7" layer="51"/>
<rectangle x1="0.45" y1="-0.7" x2="0.6" y2="-0.45" layer="21"/>
</package>
<package name="LD260" urn="urn:adsk.eagle:footprint:15652/1" library_version="5">
<description>&lt;B&gt;LED&lt;/B&gt;&lt;p&gt;
5 mm, square, Siemens</description>
<wire x1="-1.27" y1="-1.27" x2="0" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="0" y1="-1.27" x2="1.27" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="1.27" y1="1.27" x2="0" y2="1.27" width="0.1524" layer="21"/>
<wire x1="0" y1="1.27" x2="-1.27" y2="1.27" width="0.1524" layer="21"/>
<wire x1="1.27" y1="-1.27" x2="1.27" y2="-0.889" width="0.1524" layer="21"/>
<wire x1="1.27" y1="1.27" x2="1.27" y2="0.889" width="0.1524" layer="21"/>
<wire x1="1.27" y1="0.889" x2="1.27" y2="0" width="0.1524" layer="51"/>
<wire x1="1.27" y1="0" x2="1.27" y2="-0.889" width="0.1524" layer="51"/>
<wire x1="-1.27" y1="1.27" x2="-1.27" y2="0.889" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="-1.27" x2="-1.27" y2="-0.889" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="-0.889" x2="-1.27" y2="0" width="0.1524" layer="51"/>
<wire x1="-1.27" y1="0" x2="-1.27" y2="0.889" width="0.1524" layer="51"/>
<wire x1="0" y1="1.27" x2="0.9917" y2="0.7934" width="0.1524" layer="21" curve="-51.33923"/>
<wire x1="-0.9917" y1="0.7934" x2="0" y2="1.27" width="0.1524" layer="21" curve="-51.33923"/>
<wire x1="0" y1="-1.27" x2="0.9917" y2="-0.7934" width="0.1524" layer="21" curve="51.33923"/>
<wire x1="-0.9917" y1="-0.7934" x2="0" y2="-1.27" width="0.1524" layer="21" curve="51.33923"/>
<wire x1="0.9558" y1="-0.8363" x2="1.27" y2="0" width="0.1524" layer="51" curve="41.185419"/>
<wire x1="0.9756" y1="0.813" x2="1.2699" y2="0" width="0.1524" layer="51" curve="-39.806332"/>
<wire x1="-1.27" y1="0" x2="-0.9643" y2="-0.8265" width="0.1524" layer="51" curve="40.600331"/>
<wire x1="-1.27" y1="0" x2="-0.9643" y2="0.8265" width="0.1524" layer="51" curve="-40.600331"/>
<wire x1="-0.889" y1="0" x2="0" y2="0.889" width="0.1524" layer="51" curve="-90"/>
<wire x1="-0.508" y1="0" x2="0" y2="0.508" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-0.508" x2="0.508" y2="0" width="0.1524" layer="21" curve="90"/>
<wire x1="0" y1="-0.889" x2="0.889" y2="0" width="0.1524" layer="51" curve="90"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="octagon"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="octagon"/>
<text x="-1.2954" y="1.4732" size="1.016" layer="25" ratio="10">&gt;NAME</text>
<text x="-1.27" y="-2.4892" size="1.016" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="1.27" y1="-0.635" x2="2.032" y2="0.635" layer="51"/>
<rectangle x1="1.905" y1="-0.635" x2="2.032" y2="0.635" layer="21"/>
</package>
<package name="LED2X5" urn="urn:adsk.eagle:footprint:15653/1" library_version="5">
<description>&lt;B&gt;LED&lt;/B&gt;&lt;p&gt;
2 x 5 mm, rectangle</description>
<wire x1="-2.54" y1="-1.27" x2="2.54" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="2.54" y1="1.27" x2="2.54" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="2.54" y1="1.27" x2="-2.54" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-1.27" x2="-2.54" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="0" x2="0.508" y2="0" width="0.1524" layer="51"/>
<wire x1="-0.508" y1="0.381" x2="-0.508" y2="-0.381" width="0.1524" layer="51"/>
<wire x1="-0.508" y1="0.381" x2="0.508" y2="0" width="0.1524" layer="51"/>
<wire x1="0.508" y1="0" x2="1.778" y2="0" width="0.1524" layer="51"/>
<wire x1="0.508" y1="0" x2="-0.508" y2="-0.381" width="0.1524" layer="51"/>
<wire x1="0.508" y1="0.381" x2="0.508" y2="0" width="0.1524" layer="51"/>
<wire x1="0.508" y1="0" x2="0.508" y2="-0.381" width="0.1524" layer="51"/>
<wire x1="0.889" y1="-0.254" x2="1.143" y2="-0.762" width="0.1524" layer="51"/>
<wire x1="1.143" y1="-0.762" x2="1.143" y2="-0.508" width="0.1524" layer="51"/>
<wire x1="1.143" y1="-0.762" x2="0.9398" y2="-0.6096" width="0.1524" layer="51"/>
<wire x1="0.9398" y1="-0.6096" x2="1.143" y2="-0.508" width="0.1524" layer="51"/>
<wire x1="1.397" y1="-0.254" x2="1.651" y2="-0.762" width="0.1524" layer="51"/>
<wire x1="1.651" y1="-0.762" x2="1.651" y2="-0.508" width="0.1524" layer="51"/>
<wire x1="1.651" y1="-0.762" x2="1.4478" y2="-0.6096" width="0.1524" layer="51"/>
<wire x1="1.4478" y1="-0.6096" x2="1.651" y2="-0.508" width="0.1524" layer="51"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="octagon"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="octagon"/>
<text x="-2.54" y="1.397" size="1.016" layer="25" ratio="10">&gt;NAME</text>
<text x="-2.54" y="-2.413" size="1.016" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="2.159" y1="-1.27" x2="2.413" y2="1.27" layer="21"/>
</package>
<package name="LED3MM" urn="urn:adsk.eagle:footprint:15654/1" library_version="5">
<description>&lt;B&gt;LED&lt;/B&gt;&lt;p&gt;
3 mm, round</description>
<wire x1="1.5748" y1="-1.27" x2="1.5748" y2="1.27" width="0.254" layer="51"/>
<wire x1="-1.524" y1="0" x2="-1.1708" y2="0.9756" width="0.1524" layer="51" curve="-39.80361"/>
<wire x1="-1.524" y1="0" x2="-1.1391" y2="-1.0125" width="0.1524" layer="51" curve="41.633208"/>
<wire x1="1.1571" y1="0.9918" x2="1.524" y2="0" width="0.1524" layer="51" curve="-40.601165"/>
<wire x1="1.1708" y1="-0.9756" x2="1.524" y2="0" width="0.1524" layer="51" curve="39.80361"/>
<wire x1="0" y1="1.524" x2="1.2401" y2="0.8858" width="0.1524" layer="21" curve="-54.461337"/>
<wire x1="-1.2192" y1="0.9144" x2="0" y2="1.524" width="0.1524" layer="21" curve="-53.130102"/>
<wire x1="0" y1="-1.524" x2="1.203" y2="-0.9356" width="0.1524" layer="21" curve="52.126876"/>
<wire x1="-1.203" y1="-0.9356" x2="0" y2="-1.524" width="0.1524" layer="21" curve="52.126876"/>
<wire x1="-0.635" y1="0" x2="0" y2="0.635" width="0.1524" layer="51" curve="-90"/>
<wire x1="-1.016" y1="0" x2="0" y2="1.016" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-0.635" x2="0.635" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="0" y1="-1.016" x2="1.016" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="0" y1="2.032" x2="1.561" y2="1.3009" width="0.254" layer="21" curve="-50.193108"/>
<wire x1="-1.7929" y1="0.9562" x2="0" y2="2.032" width="0.254" layer="21" curve="-61.926949"/>
<wire x1="0" y1="-2.032" x2="1.5512" y2="-1.3126" width="0.254" layer="21" curve="49.763022"/>
<wire x1="-1.7643" y1="-1.0082" x2="0" y2="-2.032" width="0.254" layer="21" curve="60.255215"/>
<wire x1="-2.032" y1="0" x2="-1.7891" y2="0.9634" width="0.254" layer="51" curve="-28.301701"/>
<wire x1="-2.032" y1="0" x2="-1.7306" y2="-1.065" width="0.254" layer="51" curve="31.60822"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="octagon"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="octagon"/>
<text x="1.905" y="0.381" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="1.905" y="-1.651" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="LED5MM" urn="urn:adsk.eagle:footprint:15655/1" library_version="5">
<description>&lt;B&gt;LED&lt;/B&gt;&lt;p&gt;
5 mm, round</description>
<wire x1="2.54" y1="-1.905" x2="2.54" y2="1.905" width="0.2032" layer="21"/>
<wire x1="2.54" y1="-1.905" x2="2.54" y2="1.905" width="0.254" layer="21" curve="-286.260205"/>
<wire x1="-1.143" y1="0" x2="0" y2="1.143" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-1.143" x2="1.143" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-1.651" y1="0" x2="0" y2="1.651" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-1.651" x2="1.651" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-2.159" y1="0" x2="0" y2="2.159" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-2.159" x2="2.159" y2="0" width="0.1524" layer="51" curve="90"/>
<circle x="0" y="0" radius="2.54" width="0.1524" layer="21"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="octagon"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="octagon"/>
<text x="3.175" y="0.5334" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="3.2004" y="-1.8034" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="LSU260" urn="urn:adsk.eagle:footprint:15656/1" library_version="5">
<description>&lt;B&gt;LED&lt;/B&gt;&lt;p&gt;
1 mm, round, Siemens</description>
<wire x1="0" y1="-0.508" x2="-1.143" y2="-0.508" width="0.1524" layer="51"/>
<wire x1="-1.143" y1="-0.508" x2="-1.143" y2="-0.254" width="0.1524" layer="51"/>
<wire x1="-1.143" y1="0.508" x2="0" y2="0.508" width="0.1524" layer="51"/>
<wire x1="-1.143" y1="-0.254" x2="-1.397" y2="-0.254" width="0.1524" layer="51"/>
<wire x1="-1.143" y1="-0.254" x2="-1.143" y2="0.254" width="0.1524" layer="51"/>
<wire x1="-1.397" y1="-0.254" x2="-1.397" y2="0.254" width="0.1524" layer="51"/>
<wire x1="-1.397" y1="0.254" x2="-1.143" y2="0.254" width="0.1524" layer="51"/>
<wire x1="-1.143" y1="0.254" x2="-1.143" y2="0.508" width="0.1524" layer="51"/>
<wire x1="0.508" y1="-0.254" x2="1.397" y2="-0.254" width="0.1524" layer="51"/>
<wire x1="1.397" y1="-0.254" x2="1.397" y2="0.254" width="0.1524" layer="51"/>
<wire x1="1.397" y1="0.254" x2="0.508" y2="0.254" width="0.1524" layer="51"/>
<wire x1="0.381" y1="-0.381" x2="0.254" y2="-0.508" width="0.1524" layer="21"/>
<wire x1="0.254" y1="-0.508" x2="-0.254" y2="-0.508" width="0.1524" layer="21"/>
<wire x1="-0.381" y1="-0.381" x2="-0.254" y2="-0.508" width="0.1524" layer="21"/>
<wire x1="0.381" y1="0.381" x2="0.254" y2="0.508" width="0.1524" layer="21"/>
<wire x1="0.254" y1="0.508" x2="-0.254" y2="0.508" width="0.1524" layer="21"/>
<wire x1="-0.381" y1="0.381" x2="-0.254" y2="0.508" width="0.1524" layer="21"/>
<wire x1="0" y1="-0.254" x2="0.254" y2="0" width="0.1524" layer="21" curve="90"/>
<wire x1="-0.254" y1="0" x2="0" y2="0.254" width="0.1524" layer="21" curve="-90"/>
<wire x1="0.381" y1="-0.381" x2="0.381" y2="0.381" width="0.1524" layer="21" curve="90"/>
<circle x="0" y="0" radius="0.508" width="0.1524" layer="51"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="octagon"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="octagon"/>
<text x="-1.2954" y="0.8382" size="1.016" layer="25" ratio="10">&gt;NAME</text>
<text x="-1.27" y="-1.8542" size="1.016" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="-1.397" y1="-0.254" x2="-1.143" y2="0.254" layer="51"/>
<rectangle x1="0.508" y1="-0.254" x2="1.397" y2="0.254" layer="51"/>
</package>
<package name="LZR181" urn="urn:adsk.eagle:footprint:15657/1" library_version="5">
<description>&lt;B&gt;LED BLOCK&lt;/B&gt;&lt;p&gt;
1 LED, Siemens</description>
<wire x1="-1.27" y1="-1.27" x2="1.27" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="1.27" y1="-1.27" x2="1.27" y2="-0.889" width="0.1524" layer="21"/>
<wire x1="1.27" y1="1.27" x2="1.27" y2="0.889" width="0.1524" layer="21"/>
<wire x1="1.27" y1="0.889" x2="1.27" y2="-0.889" width="0.1524" layer="51"/>
<wire x1="-1.27" y1="1.27" x2="-1.27" y2="0.889" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="-1.27" x2="-1.27" y2="-0.889" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="-0.889" x2="-1.27" y2="0.889" width="0.1524" layer="51"/>
<wire x1="-0.889" y1="0" x2="0" y2="0.889" width="0.1524" layer="51" curve="-90"/>
<wire x1="-0.508" y1="0" x2="0" y2="0.508" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-0.508" x2="0.508" y2="0" width="0.1524" layer="21" curve="90"/>
<wire x1="0" y1="-0.889" x2="0.889" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-0.8678" y1="0.7439" x2="0" y2="1.143" width="0.1524" layer="21" curve="-49.396139"/>
<wire x1="0" y1="1.143" x2="0.8678" y2="0.7439" width="0.1524" layer="21" curve="-49.396139"/>
<wire x1="-0.8678" y1="-0.7439" x2="0" y2="-1.143" width="0.1524" layer="21" curve="49.396139"/>
<wire x1="0" y1="-1.143" x2="0.8678" y2="-0.7439" width="0.1524" layer="21" curve="49.396139"/>
<wire x1="0.8678" y1="0.7439" x2="1.143" y2="0" width="0.1524" layer="51" curve="-40.604135"/>
<wire x1="0.8678" y1="-0.7439" x2="1.143" y2="0" width="0.1524" layer="51" curve="40.604135"/>
<wire x1="-1.143" y1="0" x2="-0.8678" y2="0.7439" width="0.1524" layer="51" curve="-40.604135"/>
<wire x1="-1.143" y1="0" x2="-0.8678" y2="-0.7439" width="0.1524" layer="51" curve="40.604135"/>
<wire x1="-1.27" y1="1.27" x2="1.27" y2="1.27" width="0.1524" layer="21"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="octagon"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="octagon"/>
<text x="-1.2954" y="1.4732" size="1.016" layer="25" ratio="10">&gt;NAME</text>
<text x="-1.27" y="-2.4892" size="1.016" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="1.27" y1="-0.889" x2="1.524" y2="0.254" layer="51"/>
<rectangle x1="-1.524" y1="-0.254" x2="-1.27" y2="0.254" layer="51"/>
</package>
<package name="Q62902-B152" urn="urn:adsk.eagle:footprint:15658/1" library_version="5">
<description>&lt;b&gt;LED HOLDER&lt;/b&gt;&lt;p&gt;
Siemens</description>
<wire x1="-2.9718" y1="-1.8542" x2="-2.9718" y2="-0.254" width="0.1524" layer="21"/>
<wire x1="-2.9718" y1="-0.254" x2="-2.9718" y2="0.254" width="0.1524" layer="21"/>
<wire x1="-2.9718" y1="0.254" x2="-2.9718" y2="1.8542" width="0.1524" layer="21"/>
<wire x1="2.9718" y1="-1.8542" x2="-2.1082" y2="-1.8542" width="0.1524" layer="21"/>
<wire x1="-2.1082" y1="-1.8542" x2="-2.54" y2="-1.8542" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="1.8542" x2="-2.1082" y2="1.8542" width="0.1524" layer="21"/>
<wire x1="-2.1082" y1="1.8542" x2="2.9718" y2="1.8542" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-1.8542" x2="-2.54" y2="1.8542" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-1.8542" x2="-2.9718" y2="-1.8542" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="1.8542" x2="-2.9718" y2="1.8542" width="0.1524" layer="21"/>
<wire x1="-2.9718" y1="0.254" x2="-2.9718" y2="-0.254" width="0.1524" layer="21" curve="180"/>
<wire x1="-1.1486" y1="0.8814" x2="0" y2="1.4478" width="0.1524" layer="21" curve="-52.498642"/>
<wire x1="0" y1="1.4478" x2="1.1476" y2="0.8827" width="0.1524" layer="21" curve="-52.433716"/>
<wire x1="-1.1351" y1="-0.8987" x2="0" y2="-1.4478" width="0.1524" layer="21" curve="51.629985"/>
<wire x1="0" y1="-1.4478" x2="1.1305" y2="-0.9044" width="0.1524" layer="21" curve="51.339172"/>
<wire x1="1.1281" y1="-0.9074" x2="1.4478" y2="0" width="0.1524" layer="51" curve="38.811177"/>
<wire x1="1.1401" y1="0.8923" x2="1.4478" y2="0" width="0.1524" layer="51" curve="-38.048073"/>
<wire x1="-1.4478" y1="0" x2="-1.1305" y2="-0.9044" width="0.1524" layer="51" curve="38.659064"/>
<wire x1="-1.4478" y1="0" x2="-1.1456" y2="0.8853" width="0.1524" layer="51" curve="-37.696376"/>
<wire x1="0" y1="1.7018" x2="1.4674" y2="0.8618" width="0.1524" layer="21" curve="-59.573488"/>
<wire x1="-1.4618" y1="0.8714" x2="0" y2="1.7018" width="0.1524" layer="21" curve="-59.200638"/>
<wire x1="0" y1="-1.7018" x2="1.4571" y2="-0.8793" width="0.1524" layer="21" curve="58.891781"/>
<wire x1="-1.4571" y1="-0.8793" x2="0" y2="-1.7018" width="0.1524" layer="21" curve="58.891781"/>
<wire x1="-1.7018" y1="0" x2="-1.4447" y2="0.8995" width="0.1524" layer="51" curve="-31.907626"/>
<wire x1="-1.7018" y1="0" x2="-1.4502" y2="-0.8905" width="0.1524" layer="51" curve="31.551992"/>
<wire x1="1.4521" y1="0.8874" x2="1.7018" y2="0" width="0.1524" layer="51" curve="-31.429586"/>
<wire x1="1.4459" y1="-0.8975" x2="1.7018" y2="0" width="0.1524" layer="51" curve="31.828757"/>
<wire x1="-2.1082" y1="1.8542" x2="-2.1082" y2="-1.8542" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="0" x2="0" y2="0.635" width="0.1524" layer="21" curve="-90"/>
<wire x1="-1.016" y1="0" x2="0" y2="1.016" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-0.635" x2="0.635" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="0.0539" y1="-1.0699" x2="1.0699" y2="-0.0539" width="0.1524" layer="51" curve="90"/>
<wire x1="2.9718" y1="1.8542" x2="2.9718" y2="-1.8542" width="0.1524" layer="21"/>
<pad name="K" x="-1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<pad name="A" x="1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<text x="-1.905" y="2.286" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-1.905" y="-3.556" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="Q62902-B153" urn="urn:adsk.eagle:footprint:15659/1" library_version="5">
<description>&lt;b&gt;LED HOLDER&lt;/b&gt;&lt;p&gt;
Siemens</description>
<wire x1="-5.5118" y1="-3.5052" x2="-5.5118" y2="-0.254" width="0.1524" layer="21"/>
<wire x1="-5.5118" y1="-0.254" x2="-5.5118" y2="0.254" width="0.1524" layer="21"/>
<wire x1="-5.5118" y1="0.254" x2="-5.5118" y2="3.5052" width="0.1524" layer="21"/>
<wire x1="5.5118" y1="-3.5052" x2="-4.6482" y2="-3.5052" width="0.1524" layer="21"/>
<wire x1="-4.6482" y1="-3.5052" x2="-5.08" y2="-3.5052" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="3.5052" x2="-4.6482" y2="3.5052" width="0.1524" layer="21"/>
<wire x1="-4.6482" y1="3.5052" x2="5.5118" y2="3.5052" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="-3.5052" x2="-5.08" y2="3.5052" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="-3.5052" x2="-5.5118" y2="-3.5052" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="3.5052" x2="-5.5118" y2="3.5052" width="0.1524" layer="21"/>
<wire x1="-5.5118" y1="0.254" x2="-5.5118" y2="-0.254" width="0.1524" layer="21" curve="180"/>
<wire x1="-4.6482" y1="3.5052" x2="-4.6482" y2="-3.5052" width="0.1524" layer="21"/>
<wire x1="5.5118" y1="3.5052" x2="5.5118" y2="-3.5052" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="1.905" x2="-2.54" y2="-1.905" width="0.254" layer="21"/>
<wire x1="0" y1="-1.143" x2="1.143" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-1.143" y1="0" x2="0" y2="1.143" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-1.651" x2="1.651" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-1.651" y1="0" x2="0" y2="1.651" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-2.159" x2="2.159" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-2.2129" y1="0.0539" x2="-0.0539" y2="2.2129" width="0.1524" layer="51" curve="-90.010616"/>
<circle x="0" y="0" radius="2.54" width="0.1524" layer="21"/>
<circle x="0" y="0" radius="3.175" width="0.254" layer="21"/>
<pad name="A" x="1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<pad name="K" x="-1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<text x="-4.191" y="3.937" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-4.318" y="-5.08" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="Q62902-B155" urn="urn:adsk.eagle:footprint:15660/1" library_version="5">
<description>&lt;b&gt;LED HOLDER&lt;/b&gt;&lt;p&gt;
Siemens</description>
<wire x1="-1.27" y1="-3.048" x2="-1.27" y2="-2.54" width="0.1524" layer="21"/>
<wire x1="10.033" y1="3.048" x2="2.921" y2="3.048" width="0.1524" layer="21"/>
<wire x1="10.033" y1="3.048" x2="10.033" y2="-3.048" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="-3.048" x2="2.921" y2="-3.048" width="0.1524" layer="21"/>
<wire x1="2.921" y1="-3.048" x2="2.921" y2="3.048" width="0.1524" layer="21"/>
<wire x1="2.921" y1="-3.048" x2="10.033" y2="-3.048" width="0.1524" layer="21"/>
<wire x1="2.921" y1="3.048" x2="-1.27" y2="3.048" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="2.54" x2="-5.207" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="2.54" x2="-1.27" y2="3.048" width="0.1524" layer="21"/>
<wire x1="-5.207" y1="-2.54" x2="-1.27" y2="-2.54" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="-2.54" x2="-1.27" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-5.207" y1="2.54" x2="-5.207" y2="-2.54" width="0.1524" layer="21" curve="180"/>
<wire x1="-6.985" y1="0.635" x2="-6.985" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="1.397" x2="-6.096" y2="-1.397" width="0.1524" layer="21"/>
<wire x1="-5.207" y1="1.905" x2="-5.207" y2="-1.905" width="0.1524" layer="21"/>
<pad name="K" x="7.62" y="1.27" drill="0.8128" shape="long"/>
<pad name="A" x="7.62" y="-1.27" drill="0.8128" shape="long"/>
<text x="3.302" y="-2.794" size="1.016" layer="21" ratio="14">A+</text>
<text x="3.302" y="1.778" size="1.016" layer="21" ratio="14">K-</text>
<text x="11.684" y="-2.794" size="1.27" layer="25" ratio="10" rot="R90">&gt;NAME</text>
<text x="0.635" y="-4.445" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="2.921" y1="1.016" x2="6.731" y2="1.524" layer="21"/>
<rectangle x1="2.921" y1="-1.524" x2="6.731" y2="-1.016" layer="21"/>
<hole x="0" y="0" drill="0.8128"/>
</package>
<package name="Q62902-B156" urn="urn:adsk.eagle:footprint:15661/1" library_version="5">
<description>&lt;b&gt;LED HOLDER&lt;/b&gt;&lt;p&gt;
Siemens</description>
<wire x1="2.54" y1="-1.905" x2="2.54" y2="1.905" width="0.1524" layer="21"/>
<wire x1="-1.143" y1="0" x2="0" y2="1.143" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-1.143" x2="1.143" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-1.651" y1="0" x2="0" y2="1.651" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-1.651" x2="1.651" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="-2.159" y1="0" x2="0" y2="2.159" width="0.1524" layer="51" curve="-90"/>
<wire x1="0.0539" y1="-2.2129" x2="2.2129" y2="-0.0539" width="0.1524" layer="51" curve="90.005308"/>
<wire x1="2.54" y1="3.81" x2="3.81" y2="2.54" width="0.1524" layer="21"/>
<wire x1="2.54" y1="3.81" x2="-3.81" y2="3.81" width="0.1524" layer="21"/>
<wire x1="-3.81" y1="-3.81" x2="-3.81" y2="3.81" width="0.1524" layer="21"/>
<wire x1="3.81" y1="2.54" x2="3.81" y2="-3.81" width="0.1524" layer="21"/>
<wire x1="-3.81" y1="-3.81" x2="-2.54" y2="-3.81" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-3.302" x2="-2.54" y2="-3.81" width="0.1524" layer="21"/>
<wire x1="3.81" y1="-3.81" x2="2.54" y2="-3.81" width="0.1524" layer="21"/>
<wire x1="2.54" y1="-3.302" x2="2.54" y2="-3.81" width="0.1524" layer="21"/>
<wire x1="2.54" y1="-3.302" x2="-2.54" y2="-3.302" width="0.1524" layer="21"/>
<circle x="0" y="0" radius="2.54" width="0.1524" layer="21"/>
<circle x="0" y="0" radius="3.175" width="0.254" layer="21"/>
<pad name="A" x="-1.27" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="K" x="1.27" y="0" drill="1.016" shape="long" rot="R90"/>
<text x="-3.81" y="4.0894" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-3.7846" y="-5.3594" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
<text x="-3.556" y="-3.302" size="1.016" layer="21" ratio="14">+</text>
<text x="2.794" y="-3.302" size="1.016" layer="21" ratio="14">-</text>
</package>
<package name="SFH480" urn="urn:adsk.eagle:footprint:15662/1" library_version="5">
<description>&lt;B&gt;IR LED&lt;/B&gt;&lt;p&gt;
infrared emitting diode, Infineon
TO-18, lead spacing 2.54 mm, cathode marking&lt;p&gt;
Inifineon</description>
<wire x1="-2.159" y1="1.524" x2="-2.794" y2="2.159" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="2.159" x2="-2.159" y2="2.794" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="2.159" x2="-2.159" y2="2.794" width="0.1524" layer="21"/>
<wire x1="0" y1="1.778" x2="1.5358" y2="0.8959" width="0.1524" layer="21" curve="-59.743278"/>
<wire x1="-1.5358" y1="0.8959" x2="0" y2="1.778" width="0.1524" layer="21" curve="-59.743278"/>
<wire x1="-1.5358" y1="-0.8959" x2="0" y2="-1.778" width="0.1524" layer="21" curve="59.743278"/>
<wire x1="0" y1="-1.778" x2="1.5358" y2="-0.8959" width="0.1524" layer="21" curve="59.743278"/>
<wire x1="1.5142" y1="0.9318" x2="1.778" y2="0" width="0.1524" layer="51" curve="-31.606487"/>
<wire x1="1.5" y1="-0.9546" x2="1.778" y2="0" width="0.1524" layer="51" curve="32.472615"/>
<wire x1="-1.778" y1="0" x2="-1.5142" y2="-0.9318" width="0.1524" layer="51" curve="31.606487"/>
<wire x1="-1.778" y1="0" x2="-1.5" y2="0.9546" width="0.1524" layer="51" curve="-32.472615"/>
<wire x1="-0.635" y1="0" x2="0" y2="0.635" width="0.1524" layer="51" curve="-90"/>
<wire x1="-1.016" y1="0" x2="0" y2="1.016" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-0.635" x2="0.635" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="0.0539" y1="-1.0699" x2="1.0699" y2="-0.0539" width="0.1524" layer="51" curve="90"/>
<circle x="0" y="0" radius="2.667" width="0.1524" layer="21"/>
<circle x="0" y="0" radius="2.413" width="0.254" layer="21"/>
<pad name="K" x="-1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<pad name="A" x="1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<text x="-1.27" y="3.048" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-1.27" y="-4.318" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="SFH482" urn="urn:adsk.eagle:footprint:15650/1" library_version="5">
<description>&lt;B&gt;IR LED&lt;/B&gt;&lt;p&gt;
infrared emitting diode, Infineon
TO-18, lead spacing 2.54 mm, cathode marking&lt;p&gt;
Inifineon</description>
<wire x1="-2.159" y1="1.524" x2="-2.794" y2="2.159" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="2.159" x2="-2.159" y2="2.794" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="2.159" x2="-2.159" y2="2.794" width="0.1524" layer="21"/>
<wire x1="0" y1="1.778" x2="1.5358" y2="0.8959" width="0.1524" layer="21" curve="-59.743278"/>
<wire x1="-1.5358" y1="0.8959" x2="0" y2="1.778" width="0.1524" layer="21" curve="-59.743278"/>
<wire x1="-1.5358" y1="-0.8959" x2="0" y2="-1.778" width="0.1524" layer="21" curve="59.743278"/>
<wire x1="0" y1="-1.778" x2="1.5358" y2="-0.8959" width="0.1524" layer="21" curve="59.743278"/>
<wire x1="1.5142" y1="0.9318" x2="1.778" y2="0" width="0.1524" layer="51" curve="-31.606487"/>
<wire x1="1.5" y1="-0.9546" x2="1.778" y2="0" width="0.1524" layer="51" curve="32.472615"/>
<wire x1="-1.778" y1="0" x2="-1.5142" y2="-0.9318" width="0.1524" layer="51" curve="31.606487"/>
<wire x1="-1.778" y1="0" x2="-1.5" y2="0.9546" width="0.1524" layer="51" curve="-32.472615"/>
<wire x1="-0.635" y1="0" x2="0" y2="0.635" width="0.1524" layer="51" curve="-90"/>
<wire x1="-1.016" y1="0" x2="0" y2="1.016" width="0.1524" layer="51" curve="-90"/>
<wire x1="0" y1="-0.635" x2="0.635" y2="0" width="0.1524" layer="51" curve="90"/>
<wire x1="0.0539" y1="-1.0699" x2="1.0699" y2="-0.0539" width="0.1524" layer="51" curve="90"/>
<circle x="0" y="0" radius="2.667" width="0.1524" layer="21"/>
<circle x="0" y="0" radius="2.413" width="0.254" layer="21"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<text x="-1.27" y="3.048" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-1.27" y="-4.318" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="U57X32" urn="urn:adsk.eagle:footprint:15640/1" library_version="5">
<description>&lt;B&gt;LED&lt;/B&gt;&lt;p&gt;
rectangle, 5.7 x 3.2 mm</description>
<wire x1="-3.175" y1="1.905" x2="3.175" y2="1.905" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.905" x2="3.175" y2="1.905" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.905" x2="-3.175" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="1.905" x2="-3.175" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="-2.667" y1="1.397" x2="2.667" y2="1.397" width="0.1524" layer="21"/>
<wire x1="2.667" y1="-1.397" x2="2.667" y2="1.397" width="0.1524" layer="21"/>
<wire x1="2.667" y1="-1.397" x2="-2.667" y2="-1.397" width="0.1524" layer="21"/>
<wire x1="-2.667" y1="1.397" x2="-2.667" y2="-1.397" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="1.016" x2="2.54" y2="1.016" width="0.1524" layer="51"/>
<wire x1="2.286" y1="1.27" x2="2.286" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="-2.54" y1="0.508" x2="2.54" y2="0.508" width="0.1524" layer="51"/>
<wire x1="-2.54" y1="0" x2="2.54" y2="0" width="0.1524" layer="51"/>
<wire x1="-2.54" y1="-0.508" x2="2.54" y2="-0.508" width="0.1524" layer="51"/>
<wire x1="-2.54" y1="-1.016" x2="2.54" y2="-1.016" width="0.1524" layer="51"/>
<wire x1="-2.286" y1="1.27" x2="-2.286" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="-1.778" y1="1.27" x2="-1.778" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="-1.27" y1="1.27" x2="-1.27" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="-0.762" y1="1.27" x2="-0.762" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="-0.254" y1="1.27" x2="-0.254" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="0.254" y1="1.27" x2="0.254" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="0.762" y1="1.27" x2="0.762" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="1.27" y1="1.27" x2="1.27" y2="-1.27" width="0.1524" layer="51"/>
<wire x1="1.778" y1="1.27" x2="1.778" y2="-1.27" width="0.1524" layer="51"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<pad name="K" x="1.27" y="0" drill="0.8128" shape="long" rot="R90"/>
<text x="3.683" y="0.254" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="3.683" y="-1.524" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="IRL80A" urn="urn:adsk.eagle:footprint:15663/1" library_version="5">
<description>&lt;B&gt;IR LED&lt;/B&gt;&lt;p&gt;
IR transmitter Siemens</description>
<wire x1="0.889" y1="2.286" x2="0.889" y2="1.778" width="0.1524" layer="21"/>
<wire x1="0.889" y1="1.778" x2="0.889" y2="0.762" width="0.1524" layer="51"/>
<wire x1="0.889" y1="0.762" x2="0.889" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-0.635" x2="0.889" y2="-1.778" width="0.1524" layer="51"/>
<wire x1="0.889" y1="-1.778" x2="0.889" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-2.286" x2="-0.889" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-0.889" y1="2.286" x2="-0.889" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-0.889" y1="1.778" x2="-0.889" y2="0.762" width="0.1524" layer="51"/>
<wire x1="-0.889" y1="0.762" x2="-0.889" y2="-0.762" width="0.1524" layer="21"/>
<wire x1="-0.889" y1="-0.762" x2="-0.889" y2="-1.778" width="0.1524" layer="51"/>
<wire x1="-0.889" y1="-1.778" x2="-0.889" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-0.889" y1="2.286" x2="0.889" y2="2.286" width="0.1524" layer="21"/>
<wire x1="-0.889" y1="-0.762" x2="-0.889" y2="0.762" width="0.1524" layer="21" curve="-180"/>
<wire x1="-1.397" y1="0.254" x2="-1.397" y2="-0.254" width="0.0508" layer="21"/>
<wire x1="-1.143" y1="0.508" x2="-1.143" y2="-0.508" width="0.0508" layer="21"/>
<pad name="K" x="0" y="1.27" drill="0.8128" shape="octagon"/>
<pad name="A" x="0" y="-1.27" drill="0.8128" shape="octagon"/>
<text x="1.27" y="0.381" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="1.27" y="-1.651" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
<package name="P-LCC-2" urn="urn:adsk.eagle:footprint:15664/1" library_version="5">
<description>&lt;b&gt;TOPLED® High-optical Power LED (HOP)&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... ls_t675.pdf</description>
<wire x1="-1.4" y1="-1.05" x2="-1.4" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-1.4" y1="-1.6" x2="-1.1" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-1.1" y1="-1.6" x2="-0.85" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-0.85" y1="-1.6" x2="1.1" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="1.1" y1="-1.6" x2="1.4" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="1.4" y1="-1.6" x2="1.4" y2="1.6" width="0.2032" layer="51"/>
<wire x1="1.4" y1="1.6" x2="1.1" y2="1.6" width="0.2032" layer="51"/>
<wire x1="1.1" y1="1.6" x2="-1.1" y2="1.6" width="0.2032" layer="51"/>
<wire x1="-1.1" y1="1.6" x2="-1.4" y2="1.6" width="0.2032" layer="51"/>
<wire x1="-1.1" y1="1.6" x2="-1.1" y2="1.8" width="0.1016" layer="51"/>
<wire x1="-1.1" y1="1.8" x2="1.1" y2="1.8" width="0.1016" layer="51"/>
<wire x1="1.1" y1="1.8" x2="1.1" y2="1.6" width="0.1016" layer="51"/>
<wire x1="-1.1" y1="-1.6" x2="-1.1" y2="-1.8" width="0.1016" layer="51"/>
<wire x1="-1.1" y1="-1.8" x2="1.1" y2="-1.8" width="0.1016" layer="51"/>
<wire x1="1.1" y1="-1.8" x2="1.1" y2="-1.6" width="0.1016" layer="51"/>
<wire x1="-0.85" y1="-1.6" x2="-1.4" y2="-1.05" width="0.2032" layer="51"/>
<wire x1="-1.4" y1="1.6" x2="-1.4" y2="-1.05" width="0.2032" layer="51"/>
<circle x="0" y="0" radius="1.1" width="0.2032" layer="51"/>
<smd name="C" x="0" y="-2.75" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<smd name="A" x="0" y="2.75" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<text x="-2.54" y="-1.905" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="3.81" y="-1.905" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<text x="-0.635" y="2.54" size="1.27" layer="21">A</text>
<text x="-0.635" y="-3.81" size="1.27" layer="21">C</text>
<rectangle x1="-1.3" y1="-2.25" x2="1.3" y2="-0.75" layer="31"/>
<rectangle x1="-1.3" y1="0.75" x2="1.3" y2="2.25" layer="31"/>
<rectangle x1="-0.25" y1="-0.25" x2="0.25" y2="0.25" layer="21"/>
<rectangle x1="-1.4" y1="0.65" x2="1.4" y2="2.35" layer="29"/>
<rectangle x1="-1.4" y1="-2.35" x2="1.4" y2="-0.65" layer="29"/>
</package>
<package name="OSRAM-MINI-TOP-LED" urn="urn:adsk.eagle:footprint:15665/1" library_version="5">
<description>&lt;b&gt;BLUE LINETM Hyper Mini TOPLED® Hyper-Bright LED&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LB M676.pdf</description>
<wire x1="-0.6" y1="0.9" x2="-0.6" y2="-0.7" width="0.1016" layer="51"/>
<wire x1="-0.45" y1="-0.9" x2="-0.4" y2="-0.9" width="0.1016" layer="51"/>
<wire x1="-0.4" y1="-0.9" x2="0.6" y2="-0.9" width="0.1016" layer="51"/>
<wire x1="0.6" y1="-0.9" x2="0.6" y2="0.9" width="0.1016" layer="51"/>
<wire x1="0.6" y1="0.9" x2="-0.6" y2="0.9" width="0.1016" layer="51"/>
<wire x1="-0.45" y1="0.95" x2="-0.45" y2="1.1" width="0.1016" layer="51"/>
<wire x1="-0.45" y1="1.1" x2="0.45" y2="1.1" width="0.1016" layer="51"/>
<wire x1="0.45" y1="1.1" x2="0.45" y2="0.95" width="0.1016" layer="51"/>
<wire x1="-0.6" y1="-0.7" x2="-0.4" y2="-0.9" width="0.1016" layer="51"/>
<wire x1="-0.45" y1="-0.9" x2="-0.45" y2="-1.1" width="0.1016" layer="51"/>
<wire x1="-0.45" y1="-1.1" x2="0.45" y2="-1.1" width="0.1016" layer="51"/>
<wire x1="0.45" y1="-1.1" x2="0.45" y2="-0.95" width="0.1016" layer="51"/>
<smd name="A" x="0" y="2.6" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<smd name="C" x="0" y="-2.6" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<text x="-0.635" y="1.905" size="1.27" layer="21">A</text>
<text x="-0.635" y="-3.175" size="1.27" layer="21">C</text>
<text x="-2.54" y="-1.905" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="3.81" y="-1.905" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.5" y1="0.6" x2="0.5" y2="1.4" layer="29"/>
<rectangle x1="-0.5" y1="-1.4" x2="0.5" y2="-0.6" layer="29"/>
<rectangle x1="-0.15" y1="-0.6" x2="0.15" y2="-0.3" layer="51"/>
<rectangle x1="-0.45" y1="0.65" x2="0.45" y2="1.35" layer="31"/>
<rectangle x1="-0.45" y1="-1.35" x2="0.45" y2="-0.65" layer="31"/>
</package>
<package name="OSRAM-SIDELED" urn="urn:adsk.eagle:footprint:15666/1" library_version="5">
<description>&lt;b&gt;Super SIDELED® High-Current LED&lt;/b&gt;&lt;p&gt;
LG A672, LP A672 &lt;br&gt;
Source: http://www.osram.convergy.de/ ... LG_LP_A672.pdf (2004.05.13)</description>
<wire x1="-1.85" y1="-2.05" x2="-1.85" y2="-0.75" width="0.1016" layer="51"/>
<wire x1="-1.85" y1="-0.75" x2="-1.7" y2="-0.75" width="0.1016" layer="51"/>
<wire x1="-1.7" y1="-0.75" x2="-1.7" y2="0.75" width="0.1016" layer="51"/>
<wire x1="-1.7" y1="0.75" x2="-1.85" y2="0.75" width="0.1016" layer="51"/>
<wire x1="-1.85" y1="0.75" x2="-1.85" y2="2.05" width="0.1016" layer="51"/>
<wire x1="-1.85" y1="2.05" x2="0.9" y2="2.05" width="0.1016" layer="51"/>
<wire x1="0.9" y1="2.05" x2="0.9" y2="-2.05" width="0.1016" layer="51"/>
<wire x1="0.9" y1="-2.05" x2="-1.85" y2="-2.05" width="0.1016" layer="51"/>
<wire x1="0.9" y1="-2.05" x2="1.05" y2="-2.05" width="0.1016" layer="51"/>
<wire x1="1.05" y1="-2.05" x2="1.85" y2="-1.85" width="0.1016" layer="51"/>
<wire x1="1.85" y1="-1.85" x2="1.85" y2="1.85" width="0.1016" layer="51"/>
<wire x1="1.85" y1="1.85" x2="1.05" y2="2.05" width="0.1016" layer="51"/>
<wire x1="1.05" y1="2.05" x2="0.9" y2="2.05" width="0.1016" layer="51"/>
<wire x1="1.05" y1="2.05" x2="1.05" y2="-2.05" width="0.1016" layer="51"/>
<wire x1="-0.55" y1="-0.9" x2="-0.55" y2="0.9" width="0.1016" layer="51" curve="-167.319617"/>
<wire x1="-0.55" y1="-0.9" x2="0.85" y2="-1.2" width="0.1016" layer="51" style="shortdash"/>
<wire x1="-0.55" y1="0.9" x2="0.85" y2="1.2" width="0.1016" layer="51" style="shortdash"/>
<smd name="C" x="0" y="-2.5" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<smd name="A" x="0" y="2.5" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<text x="0.635" y="-3.175" size="1.27" layer="21" rot="R90">C</text>
<text x="0.635" y="2.54" size="1.27" layer="21" rot="R90">A</text>
<text x="-2.54" y="-2.54" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="3.81" y="-2.54" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-2.1" y1="-2.2" x2="2.1" y2="-0.4" layer="29"/>
<rectangle x1="-2.1" y1="0.4" x2="2.1" y2="2.2" layer="29"/>
<rectangle x1="-1.9" y1="-2.1" x2="1.9" y2="-0.6" layer="31"/>
<rectangle x1="-1.9" y1="0.6" x2="1.9" y2="2.1" layer="31"/>
<rectangle x1="-1.85" y1="-2.05" x2="-0.7" y2="-1" layer="51"/>
</package>
<package name="SMART-LED" urn="urn:adsk.eagle:footprint:15667/1" library_version="5">
<description>&lt;b&gt;SmartLEDTM Hyper-Bright LED&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LA_LO_LS_LY L896.pdf</description>
<wire x1="-0.35" y1="0.6" x2="0.35" y2="0.6" width="0.1016" layer="51" style="shortdash"/>
<wire x1="0.35" y1="0.6" x2="0.35" y2="-0.6" width="0.1016" layer="21" style="shortdash"/>
<wire x1="0.35" y1="-0.6" x2="0.15" y2="-0.6" width="0.1016" layer="51" style="shortdash"/>
<wire x1="0.15" y1="-0.6" x2="-0.35" y2="-0.6" width="0.1016" layer="51" style="shortdash"/>
<wire x1="-0.35" y1="-0.6" x2="-0.35" y2="0.6" width="0.1016" layer="21" style="shortdash"/>
<wire x1="0.35" y1="-0.4" x2="0.15" y2="-0.6" width="0.1016" layer="51" style="shortdash"/>
<smd name="A" x="0" y="0.725" dx="0.35" dy="0.35" layer="1"/>
<smd name="B" x="0" y="-0.725" dx="0.35" dy="0.35" layer="1"/>
<text x="-0.635" y="-0.635" size="1.016" layer="25" rot="R90">&gt;NAME</text>
<text x="1.905" y="-0.635" size="1.016" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.15" y1="-0.35" x2="0.15" y2="-0.05" layer="21"/>
<rectangle x1="-0.15" y1="0.6" x2="0.15" y2="0.85" layer="51"/>
<rectangle x1="-0.15" y1="-0.85" x2="0.15" y2="-0.6" layer="51"/>
</package>
<package name="P-LCC-2-TOPLED-RG" urn="urn:adsk.eagle:footprint:15668/1" library_version="5">
<description>&lt;b&gt;Hyper TOPLED® RG Hyper-Bright LED&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LA_LO_LS_LY T776.pdf</description>
<wire x1="-1.4" y1="-1.05" x2="-1.4" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-1.4" y1="-1.6" x2="-1.1" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-1.1" y1="-1.6" x2="-0.85" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-0.85" y1="-1.6" x2="1.1" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="1.1" y1="-1.6" x2="1.4" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="1.4" y1="-1.6" x2="1.4" y2="1.6" width="0.2032" layer="51"/>
<wire x1="1.4" y1="1.6" x2="1.1" y2="1.6" width="0.2032" layer="51"/>
<wire x1="1.1" y1="1.6" x2="-1.1" y2="1.6" width="0.2032" layer="51"/>
<wire x1="-1.1" y1="1.6" x2="-1.4" y2="1.6" width="0.2032" layer="51"/>
<wire x1="-1.1" y1="1.6" x2="-1.1" y2="2.45" width="0.1016" layer="51"/>
<wire x1="1.1" y1="2.45" x2="1.1" y2="1.6" width="0.1016" layer="51"/>
<wire x1="-1.1" y1="-1.6" x2="-1.1" y2="-2.45" width="0.1016" layer="51"/>
<wire x1="1.1" y1="-2.45" x2="1.1" y2="-1.6" width="0.1016" layer="51"/>
<wire x1="-0.85" y1="-1.6" x2="-1.4" y2="-1.05" width="0.2032" layer="51"/>
<wire x1="-1.4" y1="1.6" x2="-1.4" y2="-1.05" width="0.2032" layer="51"/>
<circle x="0" y="0" radius="1.1" width="0.2032" layer="21"/>
<smd name="C" x="0" y="-3.5" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<smd name="A" x="0" y="3.5" dx="4" dy="4" layer="1" stop="no" cream="no"/>
<text x="-2.54" y="-1.905" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="3.81" y="-1.905" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<text x="-0.635" y="3.29" size="1.27" layer="21">A</text>
<text x="-0.635" y="-4.56" size="1.27" layer="21">C</text>
<rectangle x1="-1.3" y1="-3" x2="1.3" y2="-1.5" layer="31"/>
<rectangle x1="-1.3" y1="1.5" x2="1.3" y2="3" layer="31"/>
<rectangle x1="-0.25" y1="-0.25" x2="0.25" y2="0.25" layer="21"/>
<rectangle x1="-1.15" y1="2.4" x2="1.15" y2="2.7" layer="51"/>
<rectangle x1="-1.15" y1="-2.7" x2="1.15" y2="-2.4" layer="51"/>
<rectangle x1="-1.5" y1="1.5" x2="1.5" y2="3.2" layer="29"/>
<rectangle x1="-1.5" y1="-3.2" x2="1.5" y2="-1.5" layer="29"/>
<hole x="0" y="0" drill="2.8"/>
</package>
<package name="MICRO-SIDELED" urn="urn:adsk.eagle:footprint:15669/1" library_version="5">
<description>&lt;b&gt;Hyper Micro SIDELED®&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LA_LO_LS_LY Y876.pdf</description>
<wire x1="0.65" y1="1.1" x2="-0.1" y2="1.1" width="0.1016" layer="51"/>
<wire x1="-0.1" y1="1.1" x2="-0.35" y2="1" width="0.1016" layer="51"/>
<wire x1="-0.35" y1="1" x2="-0.35" y2="-0.9" width="0.1016" layer="21"/>
<wire x1="-0.35" y1="-0.9" x2="-0.1" y2="-1.1" width="0.1016" layer="51"/>
<wire x1="-0.1" y1="-1.1" x2="0.65" y2="-1.1" width="0.1016" layer="51"/>
<wire x1="0.65" y1="-1.1" x2="0.65" y2="1.1" width="0.1016" layer="21"/>
<wire x1="0.6" y1="0.9" x2="0.25" y2="0.7" width="0.0508" layer="21"/>
<wire x1="0.25" y1="0.7" x2="0.25" y2="-0.7" width="0.0508" layer="21"/>
<wire x1="0.25" y1="-0.7" x2="0.6" y2="-0.9" width="0.0508" layer="21"/>
<smd name="A" x="0" y="1.95" dx="1.6" dy="1.6" layer="1" stop="no" cream="no"/>
<smd name="C" x="0" y="-1.95" dx="1.6" dy="1.6" layer="1" stop="no" cream="no"/>
<text x="-1.27" y="-1.905" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="2.54" y="-1.905" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.4" y1="1.1" x2="0.4" y2="1.8" layer="29"/>
<rectangle x1="-0.4" y1="-1.8" x2="0.4" y2="-1.1" layer="29"/>
<rectangle x1="-0.35" y1="-1.75" x2="0.35" y2="-1.15" layer="31"/>
<rectangle x1="-0.35" y1="1.15" x2="0.35" y2="1.75" layer="31"/>
<rectangle x1="-0.125" y1="1.125" x2="0.125" y2="1.75" layer="51"/>
<rectangle x1="-0.125" y1="-1.75" x2="0.125" y2="-1.125" layer="51"/>
</package>
<package name="P-LCC-4" urn="urn:adsk.eagle:footprint:15670/1" library_version="5">
<description>&lt;b&gt;Power TOPLED®&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LA_LO_LA_LY E67B.pdf</description>
<wire x1="-1.4" y1="-1.05" x2="-1.4" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-1.4" y1="-1.6" x2="-1" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-1" y1="-1.6" x2="-0.85" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="-0.85" y1="-1.6" x2="1" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="1" y1="-1.6" x2="1.4" y2="-1.6" width="0.2032" layer="51"/>
<wire x1="1.4" y1="-1.6" x2="1.4" y2="1.6" width="0.2032" layer="51"/>
<wire x1="1.4" y1="1.6" x2="1.1" y2="1.6" width="0.2032" layer="51"/>
<wire x1="1.1" y1="1.6" x2="-1" y2="1.6" width="0.2032" layer="51"/>
<wire x1="-1" y1="1.6" x2="-1.4" y2="1.6" width="0.2032" layer="51"/>
<wire x1="-1" y1="1.6" x2="-1" y2="1.8" width="0.1016" layer="51"/>
<wire x1="-1" y1="1.8" x2="-0.5" y2="1.8" width="0.1016" layer="51"/>
<wire x1="-0.5" y1="1.8" x2="-0.5" y2="1.65" width="0.1016" layer="51"/>
<wire x1="0.5" y1="1.65" x2="0.5" y2="1.8" width="0.1016" layer="51"/>
<wire x1="0.5" y1="1.8" x2="1.1" y2="1.8" width="0.1016" layer="51"/>
<wire x1="1.1" y1="1.8" x2="1.1" y2="1.6" width="0.1016" layer="51"/>
<wire x1="-1" y1="-1.6" x2="-1" y2="-1.8" width="0.1016" layer="51"/>
<wire x1="-1" y1="-1.8" x2="-0.5" y2="-1.8" width="0.1016" layer="51"/>
<wire x1="-0.5" y1="-1.8" x2="-0.5" y2="-1.65" width="0.1016" layer="51"/>
<wire x1="0.5" y1="-1.65" x2="0.5" y2="-1.8" width="0.1016" layer="51"/>
<wire x1="0.5" y1="-1.8" x2="1" y2="-1.8" width="0.1016" layer="51"/>
<wire x1="1" y1="-1.8" x2="1" y2="-1.6" width="0.1016" layer="51"/>
<wire x1="-0.85" y1="-1.6" x2="-1.4" y2="-1.05" width="0.2032" layer="51"/>
<wire x1="-1.4" y1="1.6" x2="-1.4" y2="-1.05" width="0.2032" layer="51"/>
<circle x="0" y="0" radius="1.1" width="0.2032" layer="51"/>
<smd name="A" x="-2" y="3.15" dx="3.3" dy="4.8" layer="1" stop="no" cream="no"/>
<smd name="C@3" x="2" y="3.15" dx="3.3" dy="4.8" layer="1" stop="no" cream="no"/>
<smd name="C@4" x="2" y="-3.15" dx="3.3" dy="4.8" layer="1" stop="no" cream="no"/>
<smd name="C@1" x="-2" y="-3.15" dx="3.3" dy="4.8" layer="1" stop="no" cream="no"/>
<text x="-3.81" y="-2.54" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="5.08" y="-2.54" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<text x="-1.905" y="-3.81" size="1.27" layer="21">C</text>
<text x="-1.905" y="2.54" size="1.27" layer="21">A</text>
<text x="1.27" y="2.54" size="1.27" layer="21">C</text>
<text x="1.27" y="-3.81" size="1.27" layer="21">C</text>
<rectangle x1="-1.15" y1="0.75" x2="-0.35" y2="1.85" layer="29"/>
<rectangle x1="0.35" y1="0.75" x2="1.15" y2="1.85" layer="29"/>
<rectangle x1="0.35" y1="-1.85" x2="1.15" y2="-0.75" layer="29"/>
<rectangle x1="-1.15" y1="-1.85" x2="-0.35" y2="-0.75" layer="29"/>
<rectangle x1="-1.1" y1="-1.8" x2="-0.4" y2="-0.8" layer="31"/>
<rectangle x1="0.4" y1="-1.8" x2="1.1" y2="-0.8" layer="31"/>
<rectangle x1="0.4" y1="0.8" x2="1.1" y2="1.8" layer="31"/>
<rectangle x1="-1.1" y1="0.8" x2="-0.4" y2="1.8" layer="31"/>
<rectangle x1="-0.2" y1="-0.2" x2="0.2" y2="0.2" layer="21"/>
</package>
<package name="CHIP-LED0603" urn="urn:adsk.eagle:footprint:15671/1" library_version="5">
<description>&lt;b&gt;Hyper CHIPLED Hyper-Bright LED&lt;/b&gt;&lt;p&gt;
LB Q993&lt;br&gt;
Source: http://www.osram.convergy.de/ ... Lb_q993.pdf</description>
<wire x1="-0.4" y1="0.45" x2="-0.4" y2="-0.45" width="0.1016" layer="51"/>
<wire x1="0.4" y1="0.45" x2="0.4" y2="-0.45" width="0.1016" layer="51"/>
<smd name="C" x="0" y="0.75" dx="0.8" dy="0.8" layer="1"/>
<smd name="A" x="0" y="-0.75" dx="0.8" dy="0.8" layer="1"/>
<text x="-0.635" y="-0.635" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="1.905" y="-0.635" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.45" y1="0.45" x2="0.45" y2="0.85" layer="51"/>
<rectangle x1="-0.45" y1="-0.85" x2="0.45" y2="-0.45" layer="51"/>
<rectangle x1="-0.45" y1="0" x2="-0.3" y2="0.3" layer="21"/>
<rectangle x1="0.3" y1="0" x2="0.45" y2="0.3" layer="21"/>
<rectangle x1="-0.15" y1="0" x2="0.15" y2="0.3" layer="21"/>
</package>
<package name="CHIP-LED0805" urn="urn:adsk.eagle:footprint:15672/1" library_version="5">
<description>&lt;b&gt;Hyper CHIPLED Hyper-Bright LED&lt;/b&gt;&lt;p&gt;
LB R99A&lt;br&gt;
Source: http://www.osram.convergy.de/ ... lb_r99a.pdf</description>
<wire x1="-0.625" y1="0.45" x2="-0.625" y2="-0.45" width="0.1016" layer="51"/>
<wire x1="0.625" y1="0.45" x2="0.625" y2="-0.475" width="0.1016" layer="51"/>
<smd name="C" x="0" y="1.05" dx="1.2" dy="1.2" layer="1"/>
<smd name="A" x="0" y="-1.05" dx="1.2" dy="1.2" layer="1"/>
<text x="-1.27" y="-1.27" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="2.54" y="-1.27" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.675" y1="0" x2="-0.525" y2="0.3" layer="21"/>
<rectangle x1="0.525" y1="0" x2="0.675" y2="0.3" layer="21"/>
<rectangle x1="-0.15" y1="0" x2="0.15" y2="0.3" layer="21"/>
<rectangle x1="-0.675" y1="0.45" x2="0.675" y2="1.05" layer="51"/>
<rectangle x1="-0.675" y1="-1.05" x2="0.675" y2="-0.45" layer="51"/>
</package>
<package name="MINI-TOPLED-SANTANA" urn="urn:adsk.eagle:footprint:15673/1" library_version="5">
<description>&lt;b&gt;Mini TOPLED Santana®&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LG M470.pdf</description>
<wire x1="0.7" y1="-1" x2="0.35" y2="-1" width="0.1016" layer="21"/>
<wire x1="0.35" y1="-1" x2="-0.7" y2="-1" width="0.1016" layer="21"/>
<wire x1="-0.7" y1="-1" x2="-0.7" y2="1" width="0.1016" layer="21"/>
<wire x1="-0.7" y1="1" x2="0.7" y2="1" width="0.1016" layer="21"/>
<wire x1="0.7" y1="1" x2="0.7" y2="-0.65" width="0.1016" layer="21"/>
<wire x1="0.7" y1="-0.65" x2="0.7" y2="-1" width="0.1016" layer="21"/>
<wire x1="0.45" y1="-0.7" x2="-0.45" y2="-0.7" width="0.1016" layer="21"/>
<wire x1="-0.45" y1="-0.7" x2="-0.45" y2="0.7" width="0.1016" layer="21"/>
<wire x1="-0.45" y1="0.7" x2="0.45" y2="0.7" width="0.1016" layer="21"/>
<wire x1="0.45" y1="0.7" x2="0.45" y2="-0.7" width="0.1016" layer="21"/>
<wire x1="0.7" y1="-0.65" x2="0.35" y2="-1" width="0.1016" layer="21"/>
<smd name="C" x="0" y="-2.2" dx="1.6" dy="1.6" layer="1" stop="no" cream="no"/>
<smd name="A" x="0" y="2.2" dx="1.6" dy="1.6" layer="1" stop="no" cream="no"/>
<text x="-1.27" y="-1.905" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="2.54" y="-1.905" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.55" y1="1.5" x2="0.55" y2="2.1" layer="29"/>
<rectangle x1="-0.55" y1="-2.1" x2="0.55" y2="-1.5" layer="29"/>
<rectangle x1="-0.5" y1="-2.05" x2="0.5" y2="-1.55" layer="31"/>
<rectangle x1="-0.5" y1="1.55" x2="0.5" y2="2.05" layer="31"/>
<rectangle x1="-0.2" y1="-0.4" x2="0.15" y2="-0.05" layer="21"/>
<rectangle x1="-0.5" y1="-2.1" x2="0.5" y2="-1.4" layer="51"/>
<rectangle x1="-0.5" y1="1.4" x2="0.5" y2="2.05" layer="51"/>
<rectangle x1="-0.5" y1="1" x2="0.5" y2="1.4" layer="21"/>
<rectangle x1="-0.5" y1="-1.4" x2="0.5" y2="-1.05" layer="21"/>
<hole x="0" y="0" drill="2.7"/>
</package>
<package name="CHIPLED_0805" urn="urn:adsk.eagle:footprint:15674/1" library_version="5">
<description>&lt;b&gt;CHIPLED&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LG_R971.pdf</description>
<wire x1="-0.35" y1="0.925" x2="0.35" y2="0.925" width="0.1016" layer="51" curve="162.394521"/>
<wire x1="-0.35" y1="-0.925" x2="0.35" y2="-0.925" width="0.1016" layer="51" curve="-162.394521"/>
<wire x1="0.575" y1="0.525" x2="0.575" y2="-0.525" width="0.1016" layer="51"/>
<wire x1="-0.575" y1="-0.5" x2="-0.575" y2="0.925" width="0.1016" layer="51"/>
<circle x="-0.45" y="0.85" radius="0.103" width="0.1016" layer="51"/>
<smd name="C" x="0" y="1.05" dx="1.2" dy="1.2" layer="1"/>
<smd name="A" x="0" y="-1.05" dx="1.2" dy="1.2" layer="1"/>
<text x="-1.27" y="-1.27" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="2.54" y="-1.27" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="0.3" y1="0.5" x2="0.625" y2="1" layer="51"/>
<rectangle x1="-0.325" y1="0.5" x2="-0.175" y2="0.75" layer="51"/>
<rectangle x1="0.175" y1="0.5" x2="0.325" y2="0.75" layer="51"/>
<rectangle x1="-0.2" y1="0.5" x2="0.2" y2="0.675" layer="51"/>
<rectangle x1="0.3" y1="-1" x2="0.625" y2="-0.5" layer="51"/>
<rectangle x1="-0.625" y1="-1" x2="-0.3" y2="-0.5" layer="51"/>
<rectangle x1="0.175" y1="-0.75" x2="0.325" y2="-0.5" layer="51"/>
<rectangle x1="-0.325" y1="-0.75" x2="-0.175" y2="-0.5" layer="51"/>
<rectangle x1="-0.2" y1="-0.675" x2="0.2" y2="-0.5" layer="51"/>
<rectangle x1="-0.1" y1="0" x2="0.1" y2="0.2" layer="21"/>
<rectangle x1="-0.6" y1="0.5" x2="-0.3" y2="0.8" layer="51"/>
<rectangle x1="-0.625" y1="0.925" x2="-0.3" y2="1" layer="51"/>
</package>
<package name="CHIPLED_1206" urn="urn:adsk.eagle:footprint:15675/1" library_version="5">
<description>&lt;b&gt;CHIPLED&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LG_LY N971.pdf</description>
<wire x1="-0.4" y1="1.6" x2="0.4" y2="1.6" width="0.1016" layer="51" curve="172.619069"/>
<wire x1="-0.8" y1="-0.95" x2="-0.8" y2="0.95" width="0.1016" layer="51"/>
<wire x1="0.8" y1="0.95" x2="0.8" y2="-0.95" width="0.1016" layer="51"/>
<circle x="-0.55" y="1.425" radius="0.1" width="0.1016" layer="51"/>
<smd name="C" x="0" y="1.75" dx="1.5" dy="1.5" layer="1"/>
<smd name="A" x="0" y="-1.75" dx="1.5" dy="1.5" layer="1"/>
<text x="-1.27" y="-1.27" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="2.54" y="-1.27" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.85" y1="1.525" x2="-0.35" y2="1.65" layer="51"/>
<rectangle x1="-0.85" y1="1.225" x2="-0.625" y2="1.55" layer="51"/>
<rectangle x1="-0.45" y1="1.225" x2="-0.325" y2="1.45" layer="51"/>
<rectangle x1="-0.65" y1="1.225" x2="-0.225" y2="1.35" layer="51"/>
<rectangle x1="0.35" y1="1.3" x2="0.85" y2="1.65" layer="51"/>
<rectangle x1="0.25" y1="1.225" x2="0.85" y2="1.35" layer="51"/>
<rectangle x1="-0.85" y1="0.95" x2="0.85" y2="1.25" layer="51"/>
<rectangle x1="-0.85" y1="-1.65" x2="0.85" y2="-0.95" layer="51"/>
<rectangle x1="-0.85" y1="0.35" x2="-0.525" y2="0.775" layer="21"/>
<rectangle x1="0.525" y1="0.35" x2="0.85" y2="0.775" layer="21"/>
<rectangle x1="-0.175" y1="0" x2="0.175" y2="0.35" layer="21"/>
</package>
<package name="CHIPLED_0603" urn="urn:adsk.eagle:footprint:15676/1" library_version="5">
<description>&lt;b&gt;CHIPLED&lt;/b&gt;&lt;p&gt;
Source: http://www.osram.convergy.de/ ... LG_LY Q971.pdf</description>
<wire x1="-0.3" y1="0.8" x2="0.3" y2="0.8" width="0.1016" layer="51" curve="170.055574"/>
<wire x1="-0.275" y1="-0.825" x2="0.275" y2="-0.825" width="0.0508" layer="51" curve="-180"/>
<wire x1="-0.4" y1="0.375" x2="-0.4" y2="-0.35" width="0.1016" layer="51"/>
<wire x1="0.4" y1="0.35" x2="0.4" y2="-0.35" width="0.1016" layer="51"/>
<circle x="-0.35" y="0.625" radius="0.075" width="0.0508" layer="51"/>
<smd name="C" x="0" y="0.75" dx="0.8" dy="0.8" layer="1"/>
<smd name="A" x="0" y="-0.75" dx="0.8" dy="0.8" layer="1"/>
<text x="-0.635" y="-1.27" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="1.905" y="-1.27" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.45" y1="0.7" x2="-0.25" y2="0.85" layer="51"/>
<rectangle x1="-0.275" y1="0.55" x2="-0.225" y2="0.6" layer="51"/>
<rectangle x1="-0.45" y1="0.35" x2="-0.4" y2="0.725" layer="51"/>
<rectangle x1="0.25" y1="0.55" x2="0.45" y2="0.85" layer="51"/>
<rectangle x1="-0.45" y1="0.35" x2="0.45" y2="0.575" layer="51"/>
<rectangle x1="-0.45" y1="-0.85" x2="-0.25" y2="-0.35" layer="51"/>
<rectangle x1="0.25" y1="-0.85" x2="0.45" y2="-0.35" layer="51"/>
<rectangle x1="-0.275" y1="-0.575" x2="0.275" y2="-0.35" layer="51"/>
<rectangle x1="-0.275" y1="-0.65" x2="-0.175" y2="-0.55" layer="51"/>
<rectangle x1="0.175" y1="-0.65" x2="0.275" y2="-0.55" layer="51"/>
<rectangle x1="-0.125" y1="0" x2="0.125" y2="0.25" layer="21"/>
</package>
<package name="CHIPLED-0603-TTW" urn="urn:adsk.eagle:footprint:15677/1" library_version="5">
<description>&lt;b&gt;CHIPLED-0603&lt;/b&gt;&lt;p&gt;
Recommended Solder Pad useable for SmartLEDTM and Chipled - Package 0603&lt;br&gt;
Package able to withstand TTW-soldering heat&lt;br&gt;
Package suitable for TTW-soldering&lt;br&gt;
Source: http://www.osram.convergy.de/ ... LO_LS_LY L89K.pdf</description>
<wire x1="-0.3" y1="0.8" x2="0.3" y2="0.8" width="0.1016" layer="51" curve="170.055574"/>
<wire x1="-0.275" y1="-0.825" x2="0.275" y2="-0.825" width="0.0508" layer="51" curve="-180"/>
<wire x1="-0.4" y1="0.375" x2="-0.4" y2="-0.35" width="0.1016" layer="51"/>
<wire x1="0.4" y1="0.35" x2="0.4" y2="-0.35" width="0.1016" layer="51"/>
<circle x="-0.35" y="0.625" radius="0.075" width="0.0508" layer="51"/>
<smd name="C" x="0" y="0.875" dx="0.8" dy="0.5" layer="1" stop="no" cream="no"/>
<smd name="A" x="0" y="-0.875" dx="0.8" dy="0.5" layer="1" stop="no" cream="no"/>
<smd name="A@1" x="0" y="-0.5" dx="0.35" dy="0.35" layer="1"/>
<smd name="C@1" x="0" y="0.5" dx="0.35" dy="0.35" layer="1"/>
<text x="-0.635" y="-1.27" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="1.905" y="-1.27" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.45" y1="0.7" x2="-0.25" y2="0.85" layer="51"/>
<rectangle x1="-0.275" y1="0.55" x2="-0.225" y2="0.6" layer="51"/>
<rectangle x1="-0.45" y1="0.35" x2="-0.4" y2="0.725" layer="51"/>
<rectangle x1="0.25" y1="0.55" x2="0.45" y2="0.85" layer="51"/>
<rectangle x1="-0.45" y1="0.35" x2="0.45" y2="0.575" layer="51"/>
<rectangle x1="-0.45" y1="-0.85" x2="-0.25" y2="-0.35" layer="51"/>
<rectangle x1="0.25" y1="-0.85" x2="0.45" y2="-0.35" layer="51"/>
<rectangle x1="-0.275" y1="-0.575" x2="0.275" y2="-0.35" layer="51"/>
<rectangle x1="-0.275" y1="-0.65" x2="-0.175" y2="-0.55" layer="51"/>
<rectangle x1="0.175" y1="-0.65" x2="0.275" y2="-0.55" layer="51"/>
<rectangle x1="-0.125" y1="0" x2="0.125" y2="0.25" layer="21"/>
<rectangle x1="-0.175" y1="0.325" x2="0.175" y2="0.7" layer="29"/>
<rectangle x1="-0.4" y1="0.625" x2="0.4" y2="1.125" layer="29"/>
<rectangle x1="-0.4" y1="-1.125" x2="0.4" y2="-0.625" layer="29"/>
<rectangle x1="-0.175" y1="-0.675" x2="0.175" y2="-0.325" layer="29"/>
</package>
<package name="SMARTLED-TTW" urn="urn:adsk.eagle:footprint:15678/1" library_version="5">
<description>&lt;b&gt;SmartLED TTW&lt;/b&gt;&lt;p&gt;
Recommended Solder Pad useable for SmartLEDTM and Chipled - Package 0603&lt;br&gt;
Package able to withstand TTW-soldering heat&lt;br&gt;
Package suitable for TTW-soldering&lt;br&gt;
Source: http://www.osram.convergy.de/ ... LO_LS_LY L89K.pdf</description>
<wire x1="-0.35" y1="0.6" x2="0.35" y2="0.6" width="0.1016" layer="51" style="shortdash"/>
<wire x1="0.35" y1="0.6" x2="0.35" y2="-0.6" width="0.1016" layer="21" style="shortdash"/>
<wire x1="0.35" y1="-0.6" x2="0.15" y2="-0.6" width="0.1016" layer="51" style="shortdash"/>
<wire x1="0.15" y1="-0.6" x2="-0.35" y2="-0.6" width="0.1016" layer="51" style="shortdash"/>
<wire x1="-0.35" y1="-0.6" x2="-0.35" y2="0.6" width="0.1016" layer="21" style="shortdash"/>
<wire x1="0.35" y1="-0.4" x2="0.15" y2="-0.6" width="0.1016" layer="51" style="shortdash"/>
<smd name="C" x="0" y="0.875" dx="0.8" dy="0.5" layer="1" stop="no" cream="no"/>
<smd name="A" x="0" y="-0.875" dx="0.8" dy="0.5" layer="1" stop="no" cream="no"/>
<smd name="A@1" x="0" y="-0.5" dx="0.35" dy="0.35" layer="1" stop="no" cream="no"/>
<smd name="C@1" x="0" y="0.5" dx="0.35" dy="0.35" layer="1" stop="no" cream="no"/>
<text x="-0.635" y="-1.27" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="1.905" y="-1.27" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-0.175" y1="0.325" x2="0.175" y2="0.7" layer="29"/>
<rectangle x1="-0.15" y1="-0.35" x2="0.15" y2="-0.05" layer="21"/>
<rectangle x1="-0.15" y1="0.6" x2="0.15" y2="0.85" layer="51"/>
<rectangle x1="-0.15" y1="-0.85" x2="0.15" y2="-0.6" layer="51"/>
<rectangle x1="-0.225" y1="0.3" x2="0.225" y2="0.975" layer="31"/>
<rectangle x1="-0.175" y1="-0.7" x2="0.175" y2="-0.325" layer="29" rot="R180"/>
<rectangle x1="-0.225" y1="-0.975" x2="0.225" y2="-0.3" layer="31" rot="R180"/>
</package>
<package name="LUMILED+" urn="urn:adsk.eagle:footprint:15679/1" library_version="5">
<description>&lt;b&gt;Lumileds Lighting. LUXEON®&lt;/b&gt; with cool pad&lt;p&gt;
Source: K2.pdf</description>
<wire x1="-3.575" y1="2.3375" x2="-2.3375" y2="3.575" width="0.2032" layer="21"/>
<wire x1="-2.3375" y1="3.575" x2="2.3375" y2="3.575" width="0.2032" layer="21"/>
<wire x1="3.575" y1="2.3375" x2="3.575" y2="-3.575" width="0.2032" layer="21"/>
<wire x1="3.575" y1="-3.575" x2="-2.3375" y2="-3.575" width="0.2032" layer="21"/>
<wire x1="-2.3375" y1="-3.575" x2="-2.5" y2="-3.4125" width="0.2032" layer="21"/>
<wire x1="-2.5" y1="-3.4125" x2="-3.4125" y2="-2.5" width="0.2032" layer="21" curve="167.429893"/>
<wire x1="-3.4125" y1="-2.5" x2="-3.575" y2="-2.3375" width="0.2032" layer="21"/>
<wire x1="-3.575" y1="-2.3375" x2="-3.575" y2="2.3375" width="0.2032" layer="21"/>
<wire x1="2.3375" y1="3.575" x2="2.5" y2="3.4125" width="0.2032" layer="21"/>
<wire x1="2.5" y1="3.4125" x2="3.4125" y2="2.5" width="0.2032" layer="21" curve="167.429893"/>
<wire x1="3.4125" y1="2.5" x2="3.575" y2="2.3375" width="0.2032" layer="21"/>
<wire x1="-1.725" y1="2.225" x2="-1.0625" y2="2.5625" width="0.2032" layer="21" curve="-255.44999"/>
<wire x1="1.725" y1="-2.225" x2="1.0625" y2="-2.5625" width="0.2032" layer="21" curve="-255.44999"/>
<circle x="0" y="0" radius="2.725" width="0.2032" layer="51"/>
<smd name="1NC" x="-5.2" y="1.15" dx="2.9" dy="1.7" layer="1"/>
<smd name="2+" x="-5.2" y="-1.15" dx="2.9" dy="1.7" layer="1"/>
<smd name="3NC" x="5.2" y="-1.15" dx="2.9" dy="1.7" layer="1" rot="R180"/>
<smd name="4-" x="5.2" y="1.15" dx="2.9" dy="1.7" layer="1" rot="R180"/>
<text x="-3.175" y="3.81" size="1.27" layer="25">&gt;NAME</text>
<text x="-3.175" y="-5.08" size="1.27" layer="27">&gt;VALUE</text>
<rectangle x1="-5.975" y1="0.575" x2="-3.625" y2="1.6" layer="51"/>
<rectangle x1="-5.975" y1="-1.6" x2="-3.625" y2="-0.575" layer="51"/>
<rectangle x1="3.625" y1="-1.6" x2="5.975" y2="-0.575" layer="51" rot="R180"/>
<rectangle x1="3.625" y1="0.575" x2="5.975" y2="1.6" layer="51" rot="R180"/>
<polygon width="0.4064" layer="1">
<vertex x="2.3383" y="1.35"/>
<vertex x="0" y="2.7"/>
<vertex x="-2.3383" y="1.35"/>
<vertex x="-2.3383" y="-1.35"/>
<vertex x="0" y="-2.7"/>
<vertex x="2.3383" y="-1.35"/>
</polygon>
<polygon width="0.4064" layer="29">
<vertex x="2.3383" y="1.35"/>
<vertex x="0" y="2.7"/>
<vertex x="-2.3383" y="1.35"/>
<vertex x="-2.3383" y="-1.35"/>
<vertex x="0" y="-2.7"/>
<vertex x="2.3383" y="-1.35"/>
</polygon>
<polygon width="0.4064" layer="31">
<vertex x="2.3383" y="1.35"/>
<vertex x="0" y="2.7"/>
<vertex x="-2.3383" y="1.35"/>
<vertex x="-2.3383" y="-1.35"/>
<vertex x="0" y="-2.7"/>
<vertex x="2.3383" y="-1.35"/>
</polygon>
</package>
<package name="LUMILED" urn="urn:adsk.eagle:footprint:15680/1" library_version="5">
<description>&lt;b&gt;Lumileds Lighting. LUXEON®&lt;/b&gt; without cool pad&lt;p&gt;
Source: K2.pdf</description>
<wire x1="-3.575" y1="2.3375" x2="-2.3375" y2="3.575" width="0.2032" layer="21"/>
<wire x1="-2.3375" y1="3.575" x2="2.3375" y2="3.575" width="0.2032" layer="21"/>
<wire x1="3.575" y1="2.3375" x2="3.575" y2="-3.575" width="0.2032" layer="21"/>
<wire x1="3.575" y1="-3.575" x2="-2.3375" y2="-3.575" width="0.2032" layer="21"/>
<wire x1="-2.3375" y1="-3.575" x2="-2.5" y2="-3.4125" width="0.2032" layer="21"/>
<wire x1="-2.5" y1="-3.4125" x2="-3.4125" y2="-2.5" width="0.2032" layer="21" curve="167.429893"/>
<wire x1="-3.4125" y1="-2.5" x2="-3.575" y2="-2.3375" width="0.2032" layer="21"/>
<wire x1="-3.575" y1="-2.3375" x2="-3.575" y2="2.3375" width="0.2032" layer="21"/>
<wire x1="2.3375" y1="3.575" x2="2.5" y2="3.4125" width="0.2032" layer="21"/>
<wire x1="2.5" y1="3.4125" x2="3.4125" y2="2.5" width="0.2032" layer="21" curve="167.429893"/>
<wire x1="3.4125" y1="2.5" x2="3.575" y2="2.3375" width="0.2032" layer="21"/>
<wire x1="-1.725" y1="2.225" x2="-1.0625" y2="2.5625" width="0.2032" layer="21" curve="-255.44999"/>
<wire x1="1.725" y1="-2.225" x2="1.0625" y2="-2.5625" width="0.2032" layer="21" curve="-255.44999"/>
<circle x="0" y="0" radius="2.725" width="0.2032" layer="51"/>
<smd name="1NC" x="-5.2" y="1.15" dx="2.9" dy="1.7" layer="1"/>
<smd name="2+" x="-5.2" y="-1.15" dx="2.9" dy="1.7" layer="1"/>
<smd name="3NC" x="5.2" y="-1.15" dx="2.9" dy="1.7" layer="1" rot="R180"/>
<smd name="4-" x="5.2" y="1.15" dx="2.9" dy="1.7" layer="1" rot="R180"/>
<text x="-3.175" y="3.81" size="1.27" layer="25">&gt;NAME</text>
<text x="-3.175" y="-5.08" size="1.27" layer="27">&gt;VALUE</text>
<rectangle x1="-5.975" y1="0.575" x2="-3.625" y2="1.6" layer="51"/>
<rectangle x1="-5.975" y1="-1.6" x2="-3.625" y2="-0.575" layer="51"/>
<rectangle x1="3.625" y1="-1.6" x2="5.975" y2="-0.575" layer="51" rot="R180"/>
<rectangle x1="3.625" y1="0.575" x2="5.975" y2="1.6" layer="51" rot="R180"/>
<polygon width="0.4064" layer="29">
<vertex x="2.3383" y="1.35"/>
<vertex x="0" y="2.7"/>
<vertex x="-2.3383" y="1.35"/>
<vertex x="-2.3383" y="-1.35"/>
<vertex x="0" y="-2.7"/>
<vertex x="2.3383" y="-1.35"/>
</polygon>
<polygon width="0.4064" layer="31">
<vertex x="2.3383" y="1.35"/>
<vertex x="0" y="2.7"/>
<vertex x="-2.3383" y="1.35"/>
<vertex x="-2.3383" y="-1.35"/>
<vertex x="0" y="-2.7"/>
<vertex x="2.3383" y="-1.35"/>
</polygon>
</package>
<package name="LED10MM" urn="urn:adsk.eagle:footprint:15681/1" library_version="5">
<description>&lt;B&gt;LED&lt;/B&gt;&lt;p&gt;
10 mm, round</description>
<wire x1="5.08" y1="-2.54" x2="5.08" y2="2.54" width="0.254" layer="21" curve="-306.869898"/>
<wire x1="4.445" y1="0" x2="0" y2="-4.445" width="0.127" layer="21" curve="-90"/>
<wire x1="3.81" y1="0" x2="0" y2="-3.81" width="0.127" layer="21" curve="-90"/>
<wire x1="3.175" y1="0" x2="0" y2="-3.175" width="0.127" layer="21" curve="-90"/>
<wire x1="2.54" y1="0" x2="0" y2="-2.54" width="0.127" layer="21" curve="-90"/>
<wire x1="-4.445" y1="0" x2="0" y2="4.445" width="0.127" layer="21" curve="-90"/>
<wire x1="-3.81" y1="0" x2="0" y2="3.81" width="0.127" layer="21" curve="-90"/>
<wire x1="-3.175" y1="0" x2="0" y2="3.175" width="0.127" layer="21" curve="-90"/>
<wire x1="-2.54" y1="0" x2="0" y2="2.54" width="0.127" layer="21" curve="-90"/>
<wire x1="5.08" y1="2.54" x2="5.08" y2="-2.54" width="0.254" layer="21"/>
<circle x="0" y="0" radius="5.08" width="0.127" layer="21"/>
<pad name="K" x="1.27" y="0" drill="0.8128" diameter="1.6764" shape="square"/>
<pad name="A" x="-1.27" y="0" drill="0.8128" diameter="1.6764" shape="octagon"/>
<text x="6.35" y="1.27" size="1.27" layer="25">&gt;NAME</text>
<text x="6.35" y="-1.27" size="1.27" layer="27">&gt;VALUE</text>
</package>
<package name="KA-3528ASYC" urn="urn:adsk.eagle:footprint:15682/1" library_version="5">
<description>&lt;b&gt;SURFACE MOUNT LED LAMP&lt;/b&gt; 3.5x2.8mm&lt;p&gt;
Source: http://www.kingbright.com/manager/upload/pdf/KA-3528ASYC(Ver1189474662.1)</description>
<wire x1="-1.55" y1="1.35" x2="1.55" y2="1.35" width="0.1016" layer="21"/>
<wire x1="1.55" y1="1.35" x2="1.55" y2="-1.35" width="0.1016" layer="51"/>
<wire x1="1.55" y1="-1.35" x2="-1.55" y2="-1.35" width="0.1016" layer="21"/>
<wire x1="-1.55" y1="-1.35" x2="-1.55" y2="1.35" width="0.1016" layer="51"/>
<wire x1="-0.65" y1="0.95" x2="0.65" y2="0.95" width="0.1016" layer="21" curve="-68.40813"/>
<wire x1="0.65" y1="-0.95" x2="-0.65" y2="-0.95" width="0.1016" layer="21" curve="-68.40813"/>
<circle x="0" y="0" radius="1.15" width="0.1016" layer="51"/>
<smd name="A" x="-1.55" y="0" dx="1.5" dy="2.2" layer="1"/>
<smd name="C" x="1.55" y="0" dx="1.5" dy="2.2" layer="1"/>
<text x="-1.905" y="1.905" size="1.27" layer="25">&gt;NAME</text>
<text x="-1.905" y="-3.175" size="1.27" layer="27">&gt;VALUE</text>
<rectangle x1="-1.75" y1="0.6" x2="-1.6" y2="1.1" layer="51"/>
<rectangle x1="-1.75" y1="-1.1" x2="-1.6" y2="-0.6" layer="51"/>
<rectangle x1="1.6" y1="-1.1" x2="1.75" y2="-0.6" layer="51" rot="R180"/>
<rectangle x1="1.6" y1="0.6" x2="1.75" y2="1.1" layer="51" rot="R180"/>
<polygon width="0.1016" layer="51">
<vertex x="1.55" y="-1.35"/>
<vertex x="1.55" y="-0.625"/>
<vertex x="0.825" y="-1.35"/>
</polygon>
<polygon width="0.1016" layer="21">
<vertex x="1.55" y="-1.35"/>
<vertex x="1.55" y="-1.175"/>
<vertex x="1" y="-1.175"/>
<vertex x="0.825" y="-1.35"/>
</polygon>
</package>
<package name="SML0805" urn="urn:adsk.eagle:footprint:15683/1" library_version="5">
<description>&lt;b&gt;SML0805-2CW-TR (0805 PROFILE)&lt;/b&gt; COOL WHITE&lt;p&gt;
Source: http://www.ledtronics.com/ds/smd-0603/Dstr0093.pdf</description>
<wire x1="-0.95" y1="-0.55" x2="0.95" y2="-0.55" width="0.1016" layer="51"/>
<wire x1="0.95" y1="-0.55" x2="0.95" y2="0.55" width="0.1016" layer="51"/>
<wire x1="0.95" y1="0.55" x2="-0.95" y2="0.55" width="0.1016" layer="51"/>
<wire x1="-0.95" y1="0.55" x2="-0.95" y2="-0.55" width="0.1016" layer="51"/>
<wire x1="-0.175" y1="-0.025" x2="0" y2="0.15" width="0.0634" layer="21"/>
<wire x1="0" y1="0.15" x2="0.15" y2="0" width="0.0634" layer="21"/>
<wire x1="0.15" y1="0" x2="-0.025" y2="-0.175" width="0.0634" layer="21"/>
<wire x1="-0.025" y1="-0.175" x2="-0.175" y2="-0.025" width="0.0634" layer="21"/>
<circle x="-0.275" y="0.4" radius="0.125" width="0" layer="21"/>
<smd name="C" x="-1.05" y="0" dx="1.2" dy="1.2" layer="1"/>
<smd name="A" x="1.05" y="0" dx="1.2" dy="1.2" layer="1"/>
<text x="-1.5" y="1" size="1.27" layer="25">&gt;NAME</text>
<text x="-1.5" y="-2" size="1.27" layer="27">&gt;VALUE</text>
</package>
<package name="SML1206" urn="urn:adsk.eagle:footprint:15684/1" library_version="5">
<description>&lt;b&gt;SML10XXKH-TR (HIGH INTENSITY) LED&lt;/b&gt;&lt;p&gt;
&lt;table&gt;
&lt;tr&gt;&lt;td&gt;SML10R3KH-TR&lt;/td&gt;&lt;td&gt;ULTRA RED&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10E3KH-TR&lt;/td&gt;&lt;td&gt;SUPER REDSUPER BLUE&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10O3KH-TR&lt;/td&gt;&lt;td&gt;SUPER ORANGE&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10PY3KH-TR&lt;/td&gt;&lt;td&gt;PURE YELLOW&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10OY3KH-TR&lt;/td&gt;&lt;td&gt;ULTRA YELLOW&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10AG3KH-TR&lt;/td&gt;&lt;td&gt;AQUA GREEN&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10BG3KH-TR&lt;/td&gt;&lt;td&gt;BLUE GREEN&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10PB1KH-TR&lt;/td&gt;&lt;td&gt;SUPER BLUE&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;SML10CW1KH-TR&lt;/td&gt;&lt;td&gt;WHITE&lt;/td&gt;&lt;/tr&gt;
&lt;/table&gt;

Source: http://www.ledtronics.com/ds/smd-1206/dstr0094.PDF</description>
<wire x1="-1.5" y1="0.5" x2="-1.5" y2="-0.5" width="0.2032" layer="51" curve="-180"/>
<wire x1="1.5" y1="-0.5" x2="1.5" y2="0.5" width="0.2032" layer="51" curve="-180"/>
<wire x1="-1.55" y1="0.75" x2="1.55" y2="0.75" width="0.1016" layer="51"/>
<wire x1="1.55" y1="-0.75" x2="-1.55" y2="-0.75" width="0.1016" layer="51"/>
<circle x="-0.725" y="0.525" radius="0.125" width="0" layer="21"/>
<smd name="C" x="-1.75" y="0" dx="1.5" dy="1.5" layer="1"/>
<smd name="A" x="1.75" y="0" dx="1.5" dy="1.5" layer="1"/>
<text x="-1.5" y="1" size="1.27" layer="25">&gt;NAME</text>
<text x="-1.5" y="-2.5" size="1.27" layer="27">&gt;VALUE</text>
<rectangle x1="-1.6" y1="0.4" x2="-1.15" y2="0.8" layer="51"/>
<rectangle x1="-1.6" y1="-0.8" x2="-1.15" y2="-0.4" layer="51"/>
<rectangle x1="-1.175" y1="-0.6" x2="-1" y2="-0.275" layer="51"/>
<rectangle x1="1.15" y1="-0.8" x2="1.6" y2="-0.4" layer="51" rot="R180"/>
<rectangle x1="1.15" y1="0.4" x2="1.6" y2="0.8" layer="51" rot="R180"/>
<rectangle x1="1" y1="0.275" x2="1.175" y2="0.6" layer="51" rot="R180"/>
<rectangle x1="-0.1" y1="-0.1" x2="0.1" y2="0.1" layer="21"/>
</package>
<package name="SML0603" urn="urn:adsk.eagle:footprint:15685/1" library_version="5">
<description>&lt;b&gt;SML0603-XXX (HIGH INTENSITY) LED&lt;/b&gt;&lt;p&gt;
&lt;table&gt;
&lt;tr&gt;&lt;td&gt;AG3K&lt;/td&gt;&lt;td&gt;AQUA GREEN&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;B1K&lt;/td&gt;&lt;td&gt;SUPER BLUE&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;R1K&lt;/td&gt;&lt;td&gt;SUPER RED&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;R3K&lt;/td&gt;&lt;td&gt;ULTRA RED&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;O3K&lt;/td&gt;&lt;td&gt;SUPER ORANGE&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;O3KH&lt;/td&gt;&lt;td&gt;SOFT ORANGE&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;Y3KH&lt;/td&gt;&lt;td&gt;SUPER YELLOW&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;Y3K&lt;/td&gt;&lt;td&gt;SUPER YELLOW&lt;/td&gt;&lt;/tr&gt;
&lt;tr&gt;&lt;td&gt;2CW&lt;/td&gt;&lt;td&gt;WHITE&lt;/td&gt;&lt;/tr&gt;
&lt;/table&gt;
Source: http://www.ledtronics.com/ds/smd-0603/Dstr0092.pdf</description>
<wire x1="-0.75" y1="0.35" x2="0.75" y2="0.35" width="0.1016" layer="51"/>
<wire x1="0.75" y1="0.35" x2="0.75" y2="-0.35" width="0.1016" layer="51"/>
<wire x1="0.75" y1="-0.35" x2="-0.75" y2="-0.35" width="0.1016" layer="51"/>
<wire x1="-0.75" y1="-0.35" x2="-0.75" y2="0.35" width="0.1016" layer="51"/>
<wire x1="-0.45" y1="0.3" x2="-0.45" y2="-0.3" width="0.1016" layer="51"/>
<wire x1="0.45" y1="0.3" x2="0.45" y2="-0.3" width="0.1016" layer="51"/>
<wire x1="-0.2" y1="0.35" x2="0.2" y2="0.35" width="0.1016" layer="21"/>
<wire x1="-0.2" y1="-0.35" x2="0.2" y2="-0.35" width="0.1016" layer="21"/>
<smd name="C" x="-0.75" y="0" dx="0.8" dy="0.8" layer="1"/>
<smd name="A" x="0.75" y="0" dx="0.8" dy="0.8" layer="1"/>
<text x="-1" y="1" size="1.27" layer="25">&gt;NAME</text>
<text x="-1" y="-2" size="1.27" layer="27">&gt;VALUE</text>
<rectangle x1="-0.4" y1="0.175" x2="0" y2="0.4" layer="51"/>
<rectangle x1="-0.25" y1="0.175" x2="0" y2="0.4" layer="21"/>
</package>
</packages>
<packages3d>
<package3d name="1206" urn="urn:adsk.eagle:package:15796/2" type="model" library_version="5">
<description>CHICAGO MINIATURE LAMP, INC.
7022X Series SMT LEDs 1206 Package Size</description>
<packageinstances>
<packageinstance name="1206"/>
</packageinstances>
</package3d>
<package3d name="LD260" urn="urn:adsk.eagle:package:15794/1" type="box" library_version="5">
<description>LED
5 mm, square, Siemens</description>
<packageinstances>
<packageinstance name="LD260"/>
</packageinstances>
</package3d>
<package3d name="LED2X5" urn="urn:adsk.eagle:package:15800/1" type="box" library_version="5">
<description>LED
2 x 5 mm, rectangle</description>
<packageinstances>
<packageinstance name="LED2X5"/>
</packageinstances>
</package3d>
<package3d name="LED3MM" urn="urn:adsk.eagle:package:15797/1" type="box" library_version="5">
<description>LED
3 mm, round</description>
<packageinstances>
<packageinstance name="LED3MM"/>
</packageinstances>
</package3d>
<package3d name="LED5MM" urn="urn:adsk.eagle:package:15799/2" type="model" library_version="5">
<description>LED
5 mm, round</description>
<packageinstances>
<packageinstance name="LED5MM"/>
</packageinstances>
</package3d>
<package3d name="LSU260" urn="urn:adsk.eagle:package:15805/1" type="box" library_version="5">
<description>LED
1 mm, round, Siemens</description>
<packageinstances>
<packageinstance name="LSU260"/>
</packageinstances>
</package3d>
<package3d name="LZR181" urn="urn:adsk.eagle:package:15808/1" type="box" library_version="5">
<description>LED BLOCK
1 LED, Siemens</description>
<packageinstances>
<packageinstance name="LZR181"/>
</packageinstances>
</package3d>
<package3d name="Q62902-B152" urn="urn:adsk.eagle:package:15803/1" type="box" library_version="5">
<description>LED HOLDER
Siemens</description>
<packageinstances>
<packageinstance name="Q62902-B152"/>
</packageinstances>
</package3d>
<package3d name="Q62902-B153" urn="urn:adsk.eagle:package:15804/1" type="box" library_version="5">
<description>LED HOLDER
Siemens</description>
<packageinstances>
<packageinstance name="Q62902-B153"/>
</packageinstances>
</package3d>
<package3d name="Q62902-B155" urn="urn:adsk.eagle:package:15807/1" type="box" library_version="5">
<description>LED HOLDER
Siemens</description>
<packageinstances>
<packageinstance name="Q62902-B155"/>
</packageinstances>
</package3d>
<package3d name="Q62902-B156" urn="urn:adsk.eagle:package:15806/1" type="box" library_version="5">
<description>LED HOLDER
Siemens</description>
<packageinstances>
<packageinstance name="Q62902-B156"/>
</packageinstances>
</package3d>
<package3d name="SFH480" urn="urn:adsk.eagle:package:15809/1" type="box" library_version="5">
<description>IR LED
infrared emitting diode, Infineon
TO-18, lead spacing 2.54 mm, cathode marking
Inifineon</description>
<packageinstances>
<packageinstance name="SFH480"/>
</packageinstances>
</package3d>
<package3d name="SFH482" urn="urn:adsk.eagle:package:15795/1" type="box" library_version="5">
<description>IR LED
infrared emitting diode, Infineon
TO-18, lead spacing 2.54 mm, cathode marking
Inifineon</description>
<packageinstances>
<packageinstance name="SFH482"/>
</packageinstances>
</package3d>
<package3d name="U57X32" urn="urn:adsk.eagle:package:15789/1" type="box" library_version="5">
<description>LED
rectangle, 5.7 x 3.2 mm</description>
<packageinstances>
<packageinstance name="U57X32"/>
</packageinstances>
</package3d>
<package3d name="IRL80A" urn="urn:adsk.eagle:package:15810/1" type="box" library_version="5">
<description>IR LED
IR transmitter Siemens</description>
<packageinstances>
<packageinstance name="IRL80A"/>
</packageinstances>
</package3d>
<package3d name="P-LCC-2" urn="urn:adsk.eagle:package:15817/1" type="box" library_version="5">
<description>TOPLED® High-optical Power LED (HOP)
Source: http://www.osram.convergy.de/ ... ls_t675.pdf</description>
<packageinstances>
<packageinstance name="P-LCC-2"/>
</packageinstances>
</package3d>
<package3d name="OSRAM-MINI-TOP-LED" urn="urn:adsk.eagle:package:15811/1" type="box" library_version="5">
<description>BLUE LINETM Hyper Mini TOPLED® Hyper-Bright LED
Source: http://www.osram.convergy.de/ ... LB M676.pdf</description>
<packageinstances>
<packageinstance name="OSRAM-MINI-TOP-LED"/>
</packageinstances>
</package3d>
<package3d name="OSRAM-SIDELED" urn="urn:adsk.eagle:package:15812/1" type="box" library_version="5">
<description>Super SIDELED® High-Current LED
LG A672, LP A672 
Source: http://www.osram.convergy.de/ ... LG_LP_A672.pdf (2004.05.13)</description>
<packageinstances>
<packageinstance name="OSRAM-SIDELED"/>
</packageinstances>
</package3d>
<package3d name="SMART-LED" urn="urn:adsk.eagle:package:15814/1" type="box" library_version="5">
<description>SmartLEDTM Hyper-Bright LED
Source: http://www.osram.convergy.de/ ... LA_LO_LS_LY L896.pdf</description>
<packageinstances>
<packageinstance name="SMART-LED"/>
</packageinstances>
</package3d>
<package3d name="P-LCC-2-TOPLED-RG" urn="urn:adsk.eagle:package:15813/1" type="box" library_version="5">
<description>Hyper TOPLED® RG Hyper-Bright LED
Source: http://www.osram.convergy.de/ ... LA_LO_LS_LY T776.pdf</description>
<packageinstances>
<packageinstance name="P-LCC-2-TOPLED-RG"/>
</packageinstances>
</package3d>
<package3d name="MICRO-SIDELED" urn="urn:adsk.eagle:package:15815/1" type="box" library_version="5">
<description>Hyper Micro SIDELED®
Source: http://www.osram.convergy.de/ ... LA_LO_LS_LY Y876.pdf</description>
<packageinstances>
<packageinstance name="MICRO-SIDELED"/>
</packageinstances>
</package3d>
<package3d name="P-LCC-4" urn="urn:adsk.eagle:package:15816/1" type="box" library_version="5">
<description>Power TOPLED®
Source: http://www.osram.convergy.de/ ... LA_LO_LA_LY E67B.pdf</description>
<packageinstances>
<packageinstance name="P-LCC-4"/>
</packageinstances>
</package3d>
<package3d name="CHIP-LED0603" urn="urn:adsk.eagle:package:15819/3" type="model" library_version="5">
<description>Hyper CHIPLED Hyper-Bright LED
LB Q993
Source: http://www.osram.convergy.de/ ... Lb_q993.pdf</description>
<packageinstances>
<packageinstance name="CHIP-LED0603"/>
</packageinstances>
</package3d>
<package3d name="CHIP-LED0805" urn="urn:adsk.eagle:package:15818/2" type="model" library_version="5">
<description>Hyper CHIPLED Hyper-Bright LED
LB R99A
Source: http://www.osram.convergy.de/ ... lb_r99a.pdf</description>
<packageinstances>
<packageinstance name="CHIP-LED0805"/>
</packageinstances>
</package3d>
<package3d name="MINI-TOPLED-SANTANA" urn="urn:adsk.eagle:package:15820/1" type="box" library_version="5">
<description>Mini TOPLED Santana®
Source: http://www.osram.convergy.de/ ... LG M470.pdf</description>
<packageinstances>
<packageinstance name="MINI-TOPLED-SANTANA"/>
</packageinstances>
</package3d>
<package3d name="CHIPLED_0805" urn="urn:adsk.eagle:package:15821/2" type="model" library_version="5">
<description>CHIPLED
Source: http://www.osram.convergy.de/ ... LG_R971.pdf</description>
<packageinstances>
<packageinstance name="CHIPLED_0805"/>
</packageinstances>
</package3d>
<package3d name="CHIPLED_1206" urn="urn:adsk.eagle:package:15823/2" type="model" library_version="5">
<description>CHIPLED
Source: http://www.osram.convergy.de/ ... LG_LY N971.pdf</description>
<packageinstances>
<packageinstance name="CHIPLED_1206"/>
</packageinstances>
</package3d>
<package3d name="CHIPLED_0603" urn="urn:adsk.eagle:package:15822/2" type="model" library_version="5">
<description>CHIPLED
Source: http://www.osram.convergy.de/ ... LG_LY Q971.pdf</description>
<packageinstances>
<packageinstance name="CHIPLED_0603"/>
</packageinstances>
</package3d>
<package3d name="CHIPLED-0603-TTW" urn="urn:adsk.eagle:package:15824/1" type="box" library_version="5">
<description>CHIPLED-0603
Recommended Solder Pad useable for SmartLEDTM and Chipled - Package 0603
Package able to withstand TTW-soldering heat
Package suitable for TTW-soldering
Source: http://www.osram.convergy.de/ ... LO_LS_LY L89K.pdf</description>
<packageinstances>
<packageinstance name="CHIPLED-0603-TTW"/>
</packageinstances>
</package3d>
<package3d name="SMARTLED-TTW" urn="urn:adsk.eagle:package:15825/1" type="box" library_version="5">
<description>SmartLED TTW
Recommended Solder Pad useable for SmartLEDTM and Chipled - Package 0603
Package able to withstand TTW-soldering heat
Package suitable for TTW-soldering
Source: http://www.osram.convergy.de/ ... LO_LS_LY L89K.pdf</description>
<packageinstances>
<packageinstance name="SMARTLED-TTW"/>
</packageinstances>
</package3d>
<package3d name="LUMILED+" urn="urn:adsk.eagle:package:15826/1" type="box" library_version="5">
<description>Lumileds Lighting. LUXEON® with cool pad
Source: K2.pdf</description>
<packageinstances>
<packageinstance name="LUMILED+"/>
</packageinstances>
</package3d>
<package3d name="LUMILED" urn="urn:adsk.eagle:package:15827/1" type="box" library_version="5">
<description>Lumileds Lighting. LUXEON® without cool pad
Source: K2.pdf</description>
<packageinstances>
<packageinstance name="LUMILED"/>
</packageinstances>
</package3d>
<package3d name="LED10MM" urn="urn:adsk.eagle:package:15828/1" type="box" library_version="5">
<description>LED
10 mm, round</description>
<packageinstances>
<packageinstance name="LED10MM"/>
</packageinstances>
</package3d>
<package3d name="KA-3528ASYC" urn="urn:adsk.eagle:package:15831/1" type="box" library_version="5">
<description>SURFACE MOUNT LED LAMP 3.5x2.8mm
Source: http://www.kingbright.com/manager/upload/pdf/KA-3528ASYC(Ver1189474662.1)</description>
<packageinstances>
<packageinstance name="KA-3528ASYC"/>
</packageinstances>
</package3d>
<package3d name="SML0805" urn="urn:adsk.eagle:package:15830/1" type="box" library_version="5">
<description>SML0805-2CW-TR (0805 PROFILE) COOL WHITE
Source: http://www.ledtronics.com/ds/smd-0603/Dstr0093.pdf</description>
<packageinstances>
<packageinstance name="SML0805"/>
</packageinstances>
</package3d>
<package3d name="SML1206" urn="urn:adsk.eagle:package:15829/1" type="box" library_version="5">
<description>SML10XXKH-TR (HIGH INTENSITY) LED

SML10R3KH-TRULTRA RED
SML10E3KH-TRSUPER REDSUPER BLUE
SML10O3KH-TRSUPER ORANGE
SML10PY3KH-TRPURE YELLOW
SML10OY3KH-TRULTRA YELLOW
SML10AG3KH-TRAQUA GREEN
SML10BG3KH-TRBLUE GREEN
SML10PB1KH-TRSUPER BLUE
SML10CW1KH-TRWHITE


Source: http://www.ledtronics.com/ds/smd-1206/dstr0094.PDF</description>
<packageinstances>
<packageinstance name="SML1206"/>
</packageinstances>
</package3d>
<package3d name="SML0603" urn="urn:adsk.eagle:package:15832/1" type="box" library_version="5">
<description>SML0603-XXX (HIGH INTENSITY) LED

AG3KAQUA GREEN
B1KSUPER BLUE
R1KSUPER RED
R3KULTRA RED
O3KSUPER ORANGE
O3KHSOFT ORANGE
Y3KHSUPER YELLOW
Y3KSUPER YELLOW
2CWWHITE

Source: http://www.ledtronics.com/ds/smd-0603/Dstr0092.pdf</description>
<packageinstances>
<packageinstance name="SML0603"/>
</packageinstances>
</package3d>
</packages3d>
<symbols>
<symbol name="LED" urn="urn:adsk.eagle:symbol:15639/2" library_version="5">
<wire x1="1.27" y1="0" x2="0" y2="-2.54" width="0.254" layer="94"/>
<wire x1="0" y1="-2.54" x2="-1.27" y2="0" width="0.254" layer="94"/>
<wire x1="1.27" y1="-2.54" x2="0" y2="-2.54" width="0.254" layer="94"/>
<wire x1="0" y1="-2.54" x2="-1.27" y2="-2.54" width="0.254" layer="94"/>
<wire x1="1.27" y1="0" x2="0" y2="0" width="0.254" layer="94"/>
<wire x1="0" y1="0" x2="-1.27" y2="0" width="0.254" layer="94"/>
<wire x1="-2.032" y1="-0.762" x2="-3.429" y2="-2.159" width="0.1524" layer="94"/>
<wire x1="-1.905" y1="-1.905" x2="-3.302" y2="-3.302" width="0.1524" layer="94"/>
<text x="3.556" y="-4.572" size="1.778" layer="95" rot="R90">&gt;NAME</text>
<text x="5.715" y="-4.572" size="1.778" layer="96" rot="R90">&gt;VALUE</text>
<pin name="C" x="0" y="-5.08" visible="off" length="short" direction="pas" rot="R90"/>
<pin name="A" x="0" y="2.54" visible="off" length="short" direction="pas" rot="R270"/>
<polygon width="0.1524" layer="94">
<vertex x="-3.429" y="-2.159"/>
<vertex x="-3.048" y="-1.27"/>
<vertex x="-2.54" y="-1.778"/>
</polygon>
<polygon width="0.1524" layer="94">
<vertex x="-3.302" y="-3.302"/>
<vertex x="-2.921" y="-2.413"/>
<vertex x="-2.413" y="-2.921"/>
</polygon>
</symbol>
</symbols>
<devicesets>
<deviceset name="LED" urn="urn:adsk.eagle:component:15916/10" prefix="LED" uservalue="yes" library_version="5">
<description>&lt;b&gt;LED&lt;/b&gt;&lt;p&gt;
&lt;u&gt;OSRAM&lt;/u&gt;:&lt;br&gt;

- &lt;u&gt;CHIPLED&lt;/u&gt;&lt;br&gt;
LG R971, LG N971, LY N971, LG Q971, LY Q971, LO R971, LY R971
LH N974, LH R974&lt;br&gt;
LS Q976, LO Q976, LY Q976&lt;br&gt;
LO Q996&lt;br&gt;

- &lt;u&gt;Hyper CHIPLED&lt;/u&gt;&lt;br&gt;
LW Q18S&lt;br&gt;
LB Q993, LB Q99A, LB R99A&lt;br&gt;

- &lt;u&gt;SideLED&lt;/u&gt;&lt;br&gt;
LS A670, LO A670, LY A670, LG A670, LP A670&lt;br&gt;
LB A673, LV A673, LT A673, LW A673&lt;br&gt;
LH A674&lt;br&gt;
LY A675&lt;br&gt;
LS A676, LA A676, LO A676, LY A676, LW A676&lt;br&gt;
LS A679, LY A679, LG A679&lt;br&gt;

-  &lt;u&gt;Hyper Micro SIDELED®&lt;/u&gt;&lt;br&gt;
LS Y876, LA Y876, LO Y876, LY Y876&lt;br&gt;
LT Y87S&lt;br&gt;

- &lt;u&gt;SmartLED&lt;/u&gt;&lt;br&gt;
LW L88C, LW L88S&lt;br&gt;
LB L89C, LB L89S, LG L890&lt;br&gt;
LS L89K, LO L89K, LY L89K&lt;br&gt;
LS L896, LA L896, LO L896, LY L896&lt;br&gt;

- &lt;u&gt;TOPLED&lt;/u&gt;&lt;br&gt;
LS T670, LO T670, LY T670, LG T670, LP T670&lt;br&gt;
LSG T670, LSP T670, LSY T670, LOP T670, LYG T670&lt;br&gt;
LG T671, LOG T671, LSG T671&lt;br&gt;
LB T673, LV T673, LT T673, LW T673&lt;br&gt;
LH T674&lt;br&gt;
LS T676, LA T676, LO T676, LY T676, LB T676, LH T676, LSB T676, LW T676&lt;br&gt;
LB T67C, LV T67C, LT T67C, LS T67K, LO T67K, LY T67K, LW E67C&lt;br&gt;
LS E67B, LA E67B, LO E67B, LY E67B, LB E67C, LV E67C, LT E67C&lt;br&gt;
LW T67C&lt;br&gt;
LS T679, LY T679, LG T679&lt;br&gt;
LS T770, LO T770, LY T770, LG T770, LP T770&lt;br&gt;
LB T773, LV T773, LT T773, LW T773&lt;br&gt;
LH T774&lt;br&gt;
LS E675, LA E675, LY E675, LS T675&lt;br&gt;
LS T776, LA T776, LO T776, LY T776, LB T776&lt;br&gt;
LHGB T686&lt;br&gt;
LT T68C, LB T68C&lt;br&gt;

- &lt;u&gt;Hyper Mini TOPLED®&lt;/u&gt;&lt;br&gt;
LB M676&lt;br&gt;

- &lt;u&gt;Mini TOPLED Santana®&lt;/u&gt;&lt;br&gt;
LG M470&lt;br&gt;
LS M47K, LO M47K, LY M47K
&lt;p&gt;
Source: http://www.osram.convergy.de&lt;p&gt;

&lt;u&gt;LUXEON:&lt;/u&gt;&lt;br&gt;
- &lt;u&gt;LUMILED®&lt;/u&gt;&lt;br&gt;
LXK2-PW12-R00, LXK2-PW12-S00, LXK2-PW14-U00, LXK2-PW14-V00&lt;br&gt;
LXK2-PM12-R00, LXK2-PM12-S00, LXK2-PM14-U00&lt;br&gt;
LXK2-PE12-Q00, LXK2-PE12-R00, LXK2-PE12-S00, LXK2-PE14-T00, LXK2-PE14-U00&lt;br&gt;
LXK2-PB12-K00, LXK2-PB12-L00, LXK2-PB12-M00, LXK2-PB14-N00, LXK2-PB14-P00, LXK2-PB14-Q00&lt;br&gt;
LXK2-PR12-L00, LXK2-PR12-M00, LXK2-PR14-Q00, LXK2-PR14-R00&lt;br&gt;
LXK2-PD12-Q00, LXK2-PD12-R00, LXK2-PD12-S00&lt;br&gt;
LXK2-PH12-R00, LXK2-PH12-S00&lt;br&gt;
LXK2-PL12-P00, LXK2-PL12-Q00, LXK2-PL12-R00
&lt;p&gt;
Source: www.luxeon.com&lt;p&gt;

&lt;u&gt;KINGBRIGHT:&lt;/U&gt;&lt;p&gt;
KA-3528ASYC&lt;br&gt;
Source: www.kingbright.com</description>
<gates>
<gate name="G$1" symbol="LED" x="0" y="0"/>
</gates>
<devices>
<device name="SMT1206" package="1206">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15796/2"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="20" constant="no"/>
</technology>
</technologies>
</device>
<device name="LD260" package="LD260">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15794/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="SQR2X5" package="LED2X5">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15800/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="2" constant="no"/>
</technology>
</technologies>
</device>
<device name="3MM" package="LED3MM">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15797/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="97" constant="no"/>
</technology>
</technologies>
</device>
<device name="5MM" package="LED5MM">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15799/2"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="93" constant="no"/>
</technology>
</technologies>
</device>
<device name="LSU260" package="LSU260">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15805/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="LZR181" package="LZR181">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15808/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="1" constant="no"/>
</technology>
</technologies>
</device>
<device name="B152" package="Q62902-B152">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15803/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="B153" package="Q62902-B153">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15804/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="B155" package="Q62902-B155">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15807/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="B156" package="Q62902-B156">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15806/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="SFH480" package="SFH480">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15809/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="2" constant="no"/>
</technology>
</technologies>
</device>
<device name="SFH482" package="SFH482">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15795/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="SQR5.7X3.2" package="U57X32">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15789/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="IRL80A" package="IRL80A">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15810/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="P-LCC-2" package="P-LCC-2">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15817/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="2" constant="no"/>
</technology>
</technologies>
</device>
<device name="MINI-TOP" package="OSRAM-MINI-TOP-LED">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15811/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="SIDELED" package="OSRAM-SIDELED">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15812/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="2" constant="no"/>
</technology>
</technologies>
</device>
<device name="SMART-LED" package="SMART-LED">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="B"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15814/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="P-LCC-2-BACK" package="P-LCC-2-TOPLED-RG">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15813/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="MICRO-SIDELED" package="MICRO-SIDELED">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15815/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="P-LCC-4" package="P-LCC-4">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C@4"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15816/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="CHIP-LED0603" package="CHIP-LED0603">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15819/3"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="26" constant="no"/>
</technology>
</technologies>
</device>
<device name="CHIP-LED0805" package="CHIP-LED0805">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15818/2"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="68" constant="no"/>
</technology>
</technologies>
</device>
<device name="TOPLED-SANTANA" package="MINI-TOPLED-SANTANA">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15820/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="CHIPLED_0805" package="CHIPLED_0805">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15821/2"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="52" constant="no"/>
</technology>
</technologies>
</device>
<device name="CHIPLED_1206" package="CHIPLED_1206">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15823/2"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="28" constant="no"/>
</technology>
</technologies>
</device>
<device name="CHIPLED_0603" package="CHIPLED_0603">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15822/2"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="28" constant="no"/>
</technology>
</technologies>
</device>
<device name="CHIPLED-0603-TTW" package="CHIPLED-0603-TTW">
<connects>
<connect gate="G$1" pin="A" pad="A@1"/>
<connect gate="G$1" pin="C" pad="C@1"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15824/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="" package="SMARTLED-TTW">
<connects>
<connect gate="G$1" pin="A" pad="A@1"/>
<connect gate="G$1" pin="C" pad="C@1"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15825/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="3" constant="no"/>
</technology>
</technologies>
</device>
<device name="-LUMILED+" package="LUMILED+">
<connects>
<connect gate="G$1" pin="A" pad="2+"/>
<connect gate="G$1" pin="C" pad="4-"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15826/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="-LUMILED" package="LUMILED">
<connects>
<connect gate="G$1" pin="A" pad="2+"/>
<connect gate="G$1" pin="C" pad="4-"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15827/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="10MM" package="LED10MM">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="K"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15828/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="2" constant="no"/>
</technology>
</technologies>
</device>
<device name="KA-3528ASYC" package="KA-3528ASYC">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15831/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="0" constant="no"/>
</technology>
</technologies>
</device>
<device name="SML0805" package="SML0805">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15830/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="17" constant="no"/>
</technology>
</technologies>
</device>
<device name="SML1206" package="SML1206">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15829/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="6" constant="no"/>
</technology>
</technologies>
</device>
<device name="SML0603" package="SML0603">
<connects>
<connect gate="G$1" pin="A" pad="A"/>
<connect gate="G$1" pin="C" pad="C"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:15832/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="POPULARITY" value="17" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="supply1" urn="urn:adsk.eagle:library:371">
<description>&lt;b&gt;Supply Symbols&lt;/b&gt;&lt;p&gt;
 GND, VCC, 0V, +5V, -5V, etc.&lt;p&gt;
 Please keep in mind, that these devices are necessary for the
 automatic wiring of the supply signals.&lt;p&gt;
 The pin name defined in the symbol is identical to the net which is to be wired automatically.&lt;p&gt;
 In this library the device names are the same as the pin names of the symbols, therefore the correct signal names appear next to the supply symbols in the schematic.&lt;p&gt;
 &lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;</description>
<packages>
</packages>
<symbols>
<symbol name="GND" urn="urn:adsk.eagle:symbol:26925/1" library_version="1">
<wire x1="-1.905" y1="0" x2="1.905" y2="0" width="0.254" layer="94"/>
<text x="-2.54" y="-2.54" size="1.778" layer="96">&gt;VALUE</text>
<pin name="GND" x="0" y="2.54" visible="off" length="short" direction="sup" rot="R270"/>
</symbol>
</symbols>
<devicesets>
<deviceset name="GND" urn="urn:adsk.eagle:component:26954/1" prefix="GND" library_version="1">
<description>&lt;b&gt;SUPPLY SYMBOL&lt;/b&gt;</description>
<gates>
<gate name="1" symbol="GND" x="0" y="0"/>
</gates>
<devices>
<device name="">
<technologies>
<technology name=""/>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="2022-10-25_19-15-06_Library">
<packages>
<package name="SC0915_RPI">
<smd name="1" x="-9.6901" y="24.13" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="2" x="-9.6901" y="21.59" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="3" x="-9.6901" y="19.05" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="4" x="-9.6901" y="16.51" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="5" x="-9.6901" y="13.97" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="6" x="-9.6901" y="11.43" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="7" x="-9.6901" y="8.89" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="8" x="-9.6901" y="6.35" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="9" x="-9.6901" y="3.81" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="10" x="-9.6901" y="1.27" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="11" x="-9.6901" y="-1.27" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="12" x="-9.6901" y="-3.81" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="13" x="-9.6901" y="-6.35" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="14" x="-9.6901" y="-8.89" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="15" x="-9.6901" y="-11.43" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="16" x="-9.6901" y="-13.97" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="17" x="-9.6901" y="-16.51" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="18" x="-9.6901" y="-19.05" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="19" x="-9.6901" y="-21.59" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="20" x="-9.6901" y="-24.13" dx="3.2004" dy="1.6002" layer="1"/>
<smd name="21" x="9.6901" y="-24.13" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="22" x="9.6901" y="-21.59" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="23" x="9.6901" y="-19.05" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="24" x="9.6901" y="-16.51" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="25" x="9.6901" y="-13.97" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="26" x="9.6901" y="-11.43" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="27" x="9.6901" y="-8.89" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="28" x="9.6901" y="-6.35" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="29" x="9.6901" y="-3.81" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="30" x="9.6901" y="-1.27" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="31" x="9.6901" y="1.27" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="32" x="9.6901" y="3.81" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="33" x="9.6901" y="6.35" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="34" x="9.6901" y="8.89" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="35" x="9.6901" y="11.43" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="36" x="9.6901" y="13.97" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="37" x="9.6901" y="16.51" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="38" x="9.6901" y="19.05" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="39" x="9.6901" y="21.59" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="40" x="9.6901" y="24.13" dx="3.2004" dy="1.6002" layer="1" rot="R180"/>
<smd name="TP2" x="1.0008" y="24.3002" dx="1.4986" dy="1.4986" layer="1"/>
<smd name="TP3" x="-1.0008" y="24.3002" dx="1.4986" dy="1.4986" layer="1"/>
<smd name="TP4" x="-2.4994" y="17.5006" dx="1.4986" dy="1.4986" layer="1"/>
<smd name="TP5" x="-2.4994" y="15.0012" dx="1.4986" dy="1.4986" layer="1"/>
<smd name="TP6" x="-2.4994" y="12.5019" dx="1.4986" dy="1.4986" layer="1"/>
<smd name="A" x="-2.7254" y="24.0005" dx="1.0922" dy="1.8034" layer="1"/>
<smd name="B" x="2.7254" y="24.0005" dx="1.0922" dy="1.8034" layer="1"/>
<smd name="C" x="-2.4257" y="20.9702" dx="1.0414" dy="1.4478" layer="1"/>
<smd name="D" x="2.4257" y="20.9702" dx="1.0414" dy="1.4478" layer="1"/>
<smd name="D2" x="0" y="-24.699" dx="3.2004" dy="1.6002" layer="1" rot="R90"/>
<smd name="D1" x="-2.54" y="-24.699" dx="3.2004" dy="1.6002" layer="1" rot="R90"/>
<smd name="D3" x="2.54" y="-24.699" dx="3.2004" dy="1.6002" layer="1" rot="R90"/>
<smd name="TP1" x="0" y="21.0007" dx="1.4986" dy="1.4986" layer="1"/>
<wire x1="10.6299" y1="0.1372" x2="10.6299" y2="-0.1372" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="2.6772" x2="10.6299" y2="2.4028" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="5.2172" x2="10.6299" y2="4.9428" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="7.7572" x2="10.6299" y2="7.4828" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="10.2972" x2="10.6299" y2="10.0228" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="12.8372" x2="10.6299" y2="12.5628" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="15.3772" x2="10.6299" y2="15.1028" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="17.9172" x2="10.6299" y2="17.6428" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="20.4572" x2="10.6299" y2="20.1828" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="22.9972" x2="10.6299" y2="22.7228" width="0.1524" layer="21"/>
<wire x1="-1.1328" y1="-25.6286" x2="-1.4072" y2="-25.6286" width="0.1524" layer="21"/>
<wire x1="-3.6728" y1="-25.6286" x2="-10.6299" y2="-25.6286" width="0.1524" layer="21"/>
<wire x1="1.4072" y1="-25.6286" x2="1.1328" y2="-25.6286" width="0.1524" layer="21"/>
<wire x1="-4.1275" y1="25.6286" x2="-4.1275" y2="26.924" width="0.1524" layer="21"/>
<wire x1="-4.1275" y1="26.924" x2="4.1275" y2="26.924" width="0.1524" layer="21"/>
<wire x1="4.1275" y1="26.924" x2="4.1275" y2="25.6286" width="0.1524" layer="21"/>
<wire x1="4.1275" y1="25.6286" x2="10.6299" y2="25.6286" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="25.6286" x2="10.6299" y2="25.2628" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-25.6286" x2="3.6728" y2="-25.6286" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-25.6286" x2="-10.6299" y2="-25.2628" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="25.6286" x2="-4.1275" y2="25.6286" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="25.2628" x2="-10.6299" y2="25.6286" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="22.7228" x2="-10.6299" y2="22.9972" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="20.1828" x2="-10.6299" y2="20.4572" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="17.6428" x2="-10.6299" y2="17.9172" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="15.1028" x2="-10.6299" y2="15.3772" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="12.5628" x2="-10.6299" y2="12.8372" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="10.0228" x2="-10.6299" y2="10.2972" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="7.4828" x2="-10.6299" y2="7.7572" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="4.9428" x2="-10.6299" y2="5.2172" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="2.4028" x2="-10.6299" y2="2.6772" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-0.1372" x2="-10.6299" y2="0.1372" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-2.6772" x2="-10.6299" y2="-2.4028" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-5.2172" x2="-10.6299" y2="-4.9428" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-7.7572" x2="-10.6299" y2="-7.4828" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-10.2972" x2="-10.6299" y2="-10.0228" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-12.8372" x2="-10.6299" y2="-12.5628" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-15.3772" x2="-10.6299" y2="-15.1028" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-17.9172" x2="-10.6299" y2="-17.6428" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-20.4572" x2="-10.6299" y2="-20.1828" width="0.1524" layer="21"/>
<wire x1="-10.6299" y1="-22.9972" x2="-10.6299" y2="-22.7228" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-25.2628" x2="10.6299" y2="-25.6286" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-22.7228" x2="10.6299" y2="-22.9972" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-20.1828" x2="10.6299" y2="-20.4572" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-17.6428" x2="10.6299" y2="-17.9172" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-15.1028" x2="10.6299" y2="-15.3772" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-12.5628" x2="10.6299" y2="-12.8372" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-10.0228" x2="10.6299" y2="-10.2972" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-7.4828" x2="10.6299" y2="-7.7572" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-4.9428" x2="10.6299" y2="-5.2172" width="0.1524" layer="21"/>
<wire x1="10.6299" y1="-2.4028" x2="10.6299" y2="-2.6772" width="0.1524" layer="21"/>
<wire x1="-14.1351" y1="24.13" x2="-14.3891" y2="24.13" width="0.1524" layer="21" curve="-180"/>
<wire x1="-14.3891" y1="24.13" x2="-14.1351" y2="24.13" width="0.1524" layer="21" curve="-180"/>
<text x="-1.7288" y="-0.635" size="1.27" layer="21" ratio="6">&gt;Value</text>
<wire x1="-9.6901" y1="24.13" x2="-9.6901" y2="27.051" width="0.1524" layer="47"/>
<wire x1="9.6901" y1="24.13" x2="9.6901" y2="27.051" width="0.1524" layer="47"/>
<wire x1="-9.6901" y1="26.67" x2="9.6901" y2="26.67" width="0.1524" layer="47"/>
<wire x1="-9.6901" y1="26.67" x2="-9.4361" y2="26.797" width="0.1524" layer="47"/>
<wire x1="-9.6901" y1="26.67" x2="-9.4361" y2="26.543" width="0.1524" layer="47"/>
<wire x1="-9.4361" y1="26.797" x2="-9.4361" y2="26.543" width="0.1524" layer="47"/>
<wire x1="9.6901" y1="26.67" x2="9.4361" y2="26.797" width="0.1524" layer="47"/>
<wire x1="9.6901" y1="26.67" x2="9.4361" y2="26.543" width="0.1524" layer="47"/>
<wire x1="9.4361" y1="26.797" x2="9.4361" y2="26.543" width="0.1524" layer="47"/>
<wire x1="-9.6901" y1="24.13" x2="-12.6111" y2="24.13" width="0.1524" layer="47"/>
<wire x1="-9.6901" y1="21.59" x2="-12.6111" y2="21.59" width="0.1524" layer="47"/>
<wire x1="-12.2301" y1="24.13" x2="-12.2301" y2="25.4" width="0.1524" layer="47"/>
<wire x1="-12.2301" y1="21.59" x2="-12.2301" y2="20.32" width="0.1524" layer="47"/>
<wire x1="-12.2301" y1="24.13" x2="-12.3571" y2="24.384" width="0.1524" layer="47"/>
<wire x1="-12.2301" y1="24.13" x2="-12.1031" y2="24.384" width="0.1524" layer="47"/>
<wire x1="-12.3571" y1="24.384" x2="-12.1031" y2="24.384" width="0.1524" layer="47"/>
<wire x1="-12.2301" y1="21.59" x2="-12.3571" y2="21.336" width="0.1524" layer="47"/>
<wire x1="-12.2301" y1="21.59" x2="-12.1031" y2="21.336" width="0.1524" layer="47"/>
<wire x1="-12.3571" y1="21.336" x2="-12.1031" y2="21.336" width="0.1524" layer="47"/>
<wire x1="10.5029" y1="25.5016" x2="12.6111" y2="25.5016" width="0.1524" layer="47"/>
<wire x1="10.5029" y1="-25.5016" x2="12.6111" y2="-25.5016" width="0.1524" layer="47"/>
<wire x1="12.2301" y1="25.5016" x2="12.2301" y2="-25.5016" width="0.1524" layer="47"/>
<wire x1="12.2301" y1="25.5016" x2="12.1031" y2="25.2476" width="0.1524" layer="47"/>
<wire x1="12.2301" y1="25.5016" x2="12.3571" y2="25.2476" width="0.1524" layer="47"/>
<wire x1="12.1031" y1="25.2476" x2="12.3571" y2="25.2476" width="0.1524" layer="47"/>
<wire x1="12.2301" y1="-25.5016" x2="12.1031" y2="-25.2476" width="0.1524" layer="47"/>
<wire x1="12.2301" y1="-25.5016" x2="12.3571" y2="-25.2476" width="0.1524" layer="47"/>
<wire x1="12.1031" y1="-25.2476" x2="12.3571" y2="-25.2476" width="0.1524" layer="47"/>
<wire x1="-10.5029" y1="-25.5016" x2="-10.5029" y2="-28.4226" width="0.1524" layer="47"/>
<wire x1="10.5029" y1="-25.5016" x2="10.5029" y2="-28.4226" width="0.1524" layer="47"/>
<wire x1="-10.5029" y1="-28.0416" x2="10.5029" y2="-28.0416" width="0.1524" layer="47"/>
<wire x1="-10.5029" y1="-28.0416" x2="-10.2489" y2="-27.9146" width="0.1524" layer="47"/>
<wire x1="-10.5029" y1="-28.0416" x2="-10.2489" y2="-28.1686" width="0.1524" layer="47"/>
<wire x1="-10.2489" y1="-27.9146" x2="-10.2489" y2="-28.1686" width="0.1524" layer="47"/>
<wire x1="10.5029" y1="-28.0416" x2="10.2489" y2="-27.9146" width="0.1524" layer="47"/>
<wire x1="10.5029" y1="-28.0416" x2="10.2489" y2="-28.1686" width="0.1524" layer="47"/>
<wire x1="10.2489" y1="-27.9146" x2="10.2489" y2="-28.1686" width="0.1524" layer="47"/>
<text x="-15.7798" y="-34.6456" size="1.27" layer="47" ratio="6">Default Padstyle: RX126Y63D0T</text>
<text x="-14.8136" y="-39.2176" size="1.27" layer="47" ratio="6">Alt 1 Padstyle: OX60Y90D30P</text>
<text x="-14.8136" y="-40.7416" size="1.27" layer="47" ratio="6">Alt 2 Padstyle: OX90Y60D30P</text>
<text x="-4.0424" y="27.178" size="0.635" layer="47" ratio="4">0.763in/19.38mm</text>
<text x="-19.0941" y="22.5425" size="0.635" layer="47" ratio="4">0.1in/2.54mm</text>
<text x="12.7381" y="-0.3175" size="0.635" layer="47" ratio="4">2.008in/51.003mm</text>
<text x="-4.3305" y="-29.1846" size="0.635" layer="47" ratio="4">0.827in/21.006mm</text>
<wire x1="-4.0005" y1="26.797" x2="-4.0005" y2="25.5016" width="0.1524" layer="51"/>
<wire x1="-4.0005" y1="26.797" x2="4.0005" y2="26.797" width="0.1524" layer="51"/>
<wire x1="4.0005" y1="26.797" x2="4.0005" y2="25.5016" width="0.1524" layer="51"/>
<wire x1="-10.5029" y1="-25.5016" x2="10.5029" y2="-25.5016" width="0.1524" layer="51"/>
<wire x1="10.5029" y1="-25.5016" x2="10.5029" y2="25.5016" width="0.1524" layer="51"/>
<wire x1="10.5029" y1="25.5016" x2="-10.5029" y2="25.5016" width="0.1524" layer="51"/>
<wire x1="-10.5029" y1="25.5016" x2="-10.5029" y2="-25.5016" width="0.1524" layer="51"/>
<wire x1="-8.0137" y1="24.13" x2="-8.1661" y2="24.13" width="0" layer="51" curve="-180"/>
<wire x1="-8.1661" y1="24.13" x2="-8.0137" y2="24.13" width="0" layer="51" curve="-180"/>
<wire x1="0.3048" y1="25.5016" x2="-0.3048" y2="25.5016" width="0.1524" layer="51" curve="-180"/>
<text x="-3.2712" y="-0.635" size="1.27" layer="27" ratio="6">&gt;Name</text>
</package>
</packages>
<symbols>
<symbol name="SC0915">
<pin name="UART0_TX/I2C0_SDA/SPI0_RX/GP0" x="2.54" y="0" length="middle"/>
<pin name="UART0_RX/I2C0_SCL/GPI0_CSN/GP1" x="2.54" y="-2.54" length="middle"/>
<pin name="GND_2" x="2.54" y="-5.08" length="middle" direction="pas"/>
<pin name="I2C1_SDA/SPI0_SCK/GP2" x="2.54" y="-7.62" length="middle"/>
<pin name="I2C1_SCL/SPI0_TX/GP3" x="2.54" y="-10.16" length="middle"/>
<pin name="UART1_TX/I2C0_SDA/SPI0_RX/GP4" x="2.54" y="-12.7" length="middle"/>
<pin name="UART1_RX/I2C0_SCL/SPI0_CSN/GP5" x="2.54" y="-15.24" length="middle"/>
<pin name="GND_3" x="2.54" y="-17.78" length="middle" direction="pas"/>
<pin name="I2C1_SDA/SPI0_SCK/GP6" x="2.54" y="-20.32" length="middle"/>
<pin name="I2C1_SCL/SPI0_TX/GP7" x="2.54" y="-22.86" length="middle"/>
<pin name="UART1_TX/I2C0_SDA/SPI1_RX/GP8" x="2.54" y="-25.4" length="middle"/>
<pin name="UART1_RX/I2C0_SCL/SPI1_CSN/GP9" x="2.54" y="-27.94" length="middle"/>
<pin name="GND_4" x="2.54" y="-30.48" length="middle" direction="pas"/>
<pin name="I2C1_SDA/SPI1_SCK/GP10" x="2.54" y="-33.02" length="middle"/>
<pin name="I2C1_SCL/SPI1_TX/GP11" x="2.54" y="-35.56" length="middle"/>
<pin name="UART0_TX/I2C0_SDA/GPI1_RX/GP12" x="2.54" y="-38.1" length="middle"/>
<pin name="UART0_RX/I2C0_SCL/SPI1_CSN/GP13" x="2.54" y="-40.64" length="middle"/>
<pin name="GND_5" x="2.54" y="-43.18" length="middle" direction="pas"/>
<pin name="I2C1_SDA/SPI1_SCK/GP14" x="2.54" y="-45.72" length="middle"/>
<pin name="I2C1_SCL/SPI1_TX/GP15" x="2.54" y="-48.26" length="middle"/>
<pin name="UART0_TX/I2C0_SDA/SPI0_RX/GP16" x="2.54" y="-50.8" length="middle"/>
<pin name="UART0_RX/I2C0_SCL/SPI0_CSN/GP17" x="2.54" y="-53.34" length="middle"/>
<pin name="GND_6" x="2.54" y="-55.88" length="middle" direction="pas"/>
<pin name="I2C1_SDA/SPI0_SCK/GP18" x="2.54" y="-58.42" length="middle"/>
<pin name="I2C1_SCL/SPI0_TX/GP19" x="2.54" y="-60.96" length="middle"/>
<pin name="I2C0_SDA/GP20" x="2.54" y="-63.5" length="middle"/>
<pin name="I2C0_SCL/GP21" x="124.46" y="-66.04" length="middle" rot="R180"/>
<pin name="GND_7" x="124.46" y="-63.5" length="middle" direction="pas" rot="R180"/>
<pin name="GP22" x="124.46" y="-60.96" length="middle" rot="R180"/>
<pin name="RUN" x="124.46" y="-58.42" length="middle" direction="pas" rot="R180"/>
<pin name="I2C1_SDA/ADC0/GP26" x="124.46" y="-55.88" length="middle" rot="R180"/>
<pin name="I2C1_SCL/ADC1/GP27" x="124.46" y="-53.34" length="middle" rot="R180"/>
<pin name="AGND/GND" x="124.46" y="-50.8" length="middle" direction="pas" rot="R180"/>
<pin name="ADC2/GP28" x="124.46" y="-48.26" length="middle" rot="R180"/>
<pin name="ADC_VREF" x="124.46" y="-45.72" length="middle" direction="pwr" rot="R180"/>
<pin name="3V3(OUT)" x="124.46" y="-43.18" length="middle" direction="out" rot="R180"/>
<pin name="3V3_EN" x="124.46" y="-40.64" length="middle" direction="pwr" rot="R180"/>
<pin name="GND_8" x="124.46" y="-38.1" length="middle" direction="pas" rot="R180"/>
<pin name="VSYS" x="124.46" y="-35.56" length="middle" direction="pwr" rot="R180"/>
<pin name="VBUS" x="124.46" y="-33.02" length="middle" direction="pwr" rot="R180"/>
<pin name="SWCLK" x="124.46" y="-30.48" length="middle" direction="pas" rot="R180"/>
<pin name="GND_9" x="124.46" y="-27.94" length="middle" direction="pas" rot="R180"/>
<pin name="SWDIO" x="124.46" y="-25.4" length="middle" direction="pas" rot="R180"/>
<pin name="GND_10" x="124.46" y="-22.86" length="middle" direction="pas" rot="R180"/>
<pin name="USB_DM" x="124.46" y="-20.32" length="middle" direction="pas" rot="R180"/>
<pin name="USB_DP" x="124.46" y="-17.78" length="middle" direction="pas" rot="R180"/>
<pin name="GPIO/SMPS" x="124.46" y="-15.24" length="middle" direction="pas" rot="R180"/>
<pin name="GPIO25/LED" x="124.46" y="-12.7" length="middle" direction="pas" rot="R180"/>
<pin name="BOOTSEL" x="124.46" y="-10.16" length="middle" direction="pas" rot="R180"/>
<pin name="GND_11" x="124.46" y="-7.62" length="middle" direction="pas" rot="R180"/>
<pin name="GND_12" x="124.46" y="-5.08" length="middle" direction="pas" rot="R180"/>
<pin name="GND_13" x="124.46" y="-2.54" length="middle" direction="pas" rot="R180"/>
<pin name="GND" x="124.46" y="0" length="middle" direction="pas" rot="R180"/>
<wire x1="7.62" y1="5.08" x2="7.62" y2="-71.12" width="0.1524" layer="94"/>
<wire x1="7.62" y1="-71.12" x2="119.38" y2="-71.12" width="0.1524" layer="94"/>
<wire x1="119.38" y1="-71.12" x2="119.38" y2="5.08" width="0.1524" layer="94"/>
<wire x1="119.38" y1="5.08" x2="7.62" y2="5.08" width="0.1524" layer="94"/>
<text x="58.7746" y="9.1186" size="2.083" layer="95" ratio="6">&gt;Name</text>
<text x="58.1352" y="6.5786" size="2.083" layer="96" ratio="6">&gt;Value</text>
</symbol>
</symbols>
<devicesets>
<deviceset name="SC0915" prefix="U">
<gates>
<gate name="A" symbol="SC0915" x="0" y="0"/>
</gates>
<devices>
<device name="SC0915_RPI" package="SC0915_RPI">
<connects>
<connect gate="A" pin="3V3(OUT)" pad="36"/>
<connect gate="A" pin="3V3_EN" pad="37"/>
<connect gate="A" pin="ADC2/GP28" pad="34"/>
<connect gate="A" pin="ADC_VREF" pad="35"/>
<connect gate="A" pin="AGND/GND" pad="33"/>
<connect gate="A" pin="BOOTSEL" pad="TP6"/>
<connect gate="A" pin="GND" pad="D"/>
<connect gate="A" pin="GND_10" pad="TP1"/>
<connect gate="A" pin="GND_11" pad="A"/>
<connect gate="A" pin="GND_12" pad="B"/>
<connect gate="A" pin="GND_13" pad="C"/>
<connect gate="A" pin="GND_2" pad="3"/>
<connect gate="A" pin="GND_3" pad="8"/>
<connect gate="A" pin="GND_4" pad="13"/>
<connect gate="A" pin="GND_5" pad="18"/>
<connect gate="A" pin="GND_6" pad="23"/>
<connect gate="A" pin="GND_7" pad="28"/>
<connect gate="A" pin="GND_8" pad="38"/>
<connect gate="A" pin="GND_9" pad="D2"/>
<connect gate="A" pin="GP22" pad="29"/>
<connect gate="A" pin="GPIO/SMPS" pad="TP4"/>
<connect gate="A" pin="GPIO25/LED" pad="TP5"/>
<connect gate="A" pin="I2C0_SCL/GP21" pad="27"/>
<connect gate="A" pin="I2C0_SDA/GP20" pad="26"/>
<connect gate="A" pin="I2C1_SCL/ADC1/GP27" pad="32"/>
<connect gate="A" pin="I2C1_SCL/SPI0_TX/GP19" pad="25"/>
<connect gate="A" pin="I2C1_SCL/SPI0_TX/GP3" pad="5"/>
<connect gate="A" pin="I2C1_SCL/SPI0_TX/GP7" pad="10"/>
<connect gate="A" pin="I2C1_SCL/SPI1_TX/GP11" pad="15"/>
<connect gate="A" pin="I2C1_SCL/SPI1_TX/GP15" pad="20"/>
<connect gate="A" pin="I2C1_SDA/ADC0/GP26" pad="31"/>
<connect gate="A" pin="I2C1_SDA/SPI0_SCK/GP18" pad="24"/>
<connect gate="A" pin="I2C1_SDA/SPI0_SCK/GP2" pad="4"/>
<connect gate="A" pin="I2C1_SDA/SPI0_SCK/GP6" pad="9"/>
<connect gate="A" pin="I2C1_SDA/SPI1_SCK/GP10" pad="14"/>
<connect gate="A" pin="I2C1_SDA/SPI1_SCK/GP14" pad="19"/>
<connect gate="A" pin="RUN" pad="30"/>
<connect gate="A" pin="SWCLK" pad="D1"/>
<connect gate="A" pin="SWDIO" pad="D3"/>
<connect gate="A" pin="UART0_RX/I2C0_SCL/GPI0_CSN/GP1" pad="2"/>
<connect gate="A" pin="UART0_RX/I2C0_SCL/SPI0_CSN/GP17" pad="22"/>
<connect gate="A" pin="UART0_RX/I2C0_SCL/SPI1_CSN/GP13" pad="17"/>
<connect gate="A" pin="UART0_TX/I2C0_SDA/GPI1_RX/GP12" pad="16"/>
<connect gate="A" pin="UART0_TX/I2C0_SDA/SPI0_RX/GP0" pad="1"/>
<connect gate="A" pin="UART0_TX/I2C0_SDA/SPI0_RX/GP16" pad="21"/>
<connect gate="A" pin="UART1_RX/I2C0_SCL/SPI0_CSN/GP5" pad="7"/>
<connect gate="A" pin="UART1_RX/I2C0_SCL/SPI1_CSN/GP9" pad="12"/>
<connect gate="A" pin="UART1_TX/I2C0_SDA/SPI0_RX/GP4" pad="6"/>
<connect gate="A" pin="UART1_TX/I2C0_SDA/SPI1_RX/GP8" pad="11"/>
<connect gate="A" pin="USB_DM" pad="TP2"/>
<connect gate="A" pin="USB_DP" pad="TP3"/>
<connect gate="A" pin="VBUS" pad="40"/>
<connect gate="A" pin="VSYS" pad="39"/>
</connects>
<technologies>
<technology name="">
<attribute name="COPYRIGHT" value="Copyright (C) 2022 Ultra Librarian. All rights reserved." constant="no"/>
<attribute name="MANUFACTURER_PART_NUMBER" value="SC0915" constant="no"/>
<attribute name="MFR_NAME" value="Raspberry Pi" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="2022-10-25_19-18-53_Library">
<packages>
<package name="PDIP16_300MC_MCH">
<pad name="1" x="0" y="0" drill="0.8128" diameter="1.524" shape="square"/>
<pad name="2" x="0" y="-2.54" drill="0.8128" diameter="1.524"/>
<pad name="3" x="0" y="-5.08" drill="0.8128" diameter="1.524"/>
<pad name="4" x="0" y="-7.62" drill="0.8128" diameter="1.524"/>
<pad name="5" x="0" y="-10.16" drill="0.8128" diameter="1.524"/>
<pad name="6" x="0" y="-12.7" drill="0.8128" diameter="1.524"/>
<pad name="7" x="0" y="-15.24" drill="0.8128" diameter="1.524"/>
<pad name="8" x="0" y="-17.78" drill="0.8128" diameter="1.524"/>
<pad name="9" x="7.62" y="-17.78" drill="0.8128" diameter="1.524"/>
<pad name="10" x="7.62" y="-15.24" drill="0.8128" diameter="1.524"/>
<pad name="11" x="7.62" y="-12.7" drill="0.8128" diameter="1.524"/>
<pad name="12" x="7.62" y="-10.16" drill="0.8128" diameter="1.524"/>
<pad name="13" x="7.62" y="-7.62" drill="0.8128" diameter="1.524"/>
<pad name="14" x="7.62" y="-5.08" drill="0.8128" diameter="1.524"/>
<pad name="15" x="7.62" y="-2.54" drill="0.8128" diameter="1.524"/>
<pad name="16" x="7.62" y="0" drill="0.8128" diameter="1.524"/>
<wire x1="0" y1="0" x2="-2.921" y2="0" width="0.1524" layer="47"/>
<wire x1="0" y1="-2.54" x2="-2.921" y2="-2.54" width="0.1524" layer="47"/>
<wire x1="-2.54" y1="0" x2="-2.54" y2="1.27" width="0.1524" layer="47"/>
<wire x1="-2.54" y1="-2.54" x2="-2.54" y2="-3.81" width="0.1524" layer="47"/>
<wire x1="-2.54" y1="0" x2="-2.667" y2="0.254" width="0.1524" layer="47"/>
<wire x1="-2.54" y1="0" x2="-2.413" y2="0.254" width="0.1524" layer="47"/>
<wire x1="-2.667" y1="0.254" x2="-2.413" y2="0.254" width="0.1524" layer="47"/>
<wire x1="-2.54" y1="-2.54" x2="-2.667" y2="-2.794" width="0.1524" layer="47"/>
<wire x1="-2.54" y1="-2.54" x2="-2.413" y2="-2.794" width="0.1524" layer="47"/>
<wire x1="-2.667" y1="-2.794" x2="-2.413" y2="-2.794" width="0.1524" layer="47"/>
<wire x1="0" y1="-17.78" x2="0" y2="-20.701" width="0.1524" layer="47"/>
<wire x1="7.62" y1="-17.78" x2="7.62" y2="-20.701" width="0.1524" layer="47"/>
<wire x1="0" y1="-20.32" x2="7.62" y2="-20.32" width="0.1524" layer="47"/>
<wire x1="0" y1="-20.32" x2="0.254" y2="-20.193" width="0.1524" layer="47"/>
<wire x1="0" y1="-20.32" x2="0.254" y2="-20.447" width="0.1524" layer="47"/>
<wire x1="0.254" y1="-20.193" x2="0.254" y2="-20.447" width="0.1524" layer="47"/>
<wire x1="7.62" y1="-20.32" x2="7.366" y2="-20.193" width="0.1524" layer="47"/>
<wire x1="7.62" y1="-20.32" x2="7.366" y2="-20.447" width="0.1524" layer="47"/>
<wire x1="7.366" y1="-20.193" x2="7.366" y2="-20.447" width="0.1524" layer="47"/>
<wire x1="1.016" y1="-17.78" x2="1.016" y2="2.921" width="0.1524" layer="47"/>
<wire x1="6.604" y1="-17.78" x2="6.604" y2="2.921" width="0.1524" layer="47"/>
<wire x1="1.016" y1="2.54" x2="6.604" y2="2.54" width="0.1524" layer="47"/>
<wire x1="1.016" y1="2.54" x2="1.27" y2="2.667" width="0.1524" layer="47"/>
<wire x1="1.016" y1="2.54" x2="1.27" y2="2.413" width="0.1524" layer="47"/>
<wire x1="1.27" y1="2.667" x2="1.27" y2="2.413" width="0.1524" layer="47"/>
<wire x1="6.604" y1="2.54" x2="6.35" y2="2.667" width="0.1524" layer="47"/>
<wire x1="6.604" y1="2.54" x2="6.35" y2="2.413" width="0.1524" layer="47"/>
<wire x1="6.35" y1="2.667" x2="6.35" y2="2.413" width="0.1524" layer="47"/>
<wire x1="3.81" y1="1.905" x2="10.541" y2="1.905" width="0.1524" layer="47"/>
<wire x1="3.81" y1="-19.685" x2="10.541" y2="-19.685" width="0.1524" layer="47"/>
<wire x1="10.16" y1="1.905" x2="10.16" y2="-19.685" width="0.1524" layer="47"/>
<wire x1="10.16" y1="1.905" x2="10.033" y2="1.651" width="0.1524" layer="47"/>
<wire x1="10.16" y1="1.905" x2="10.287" y2="1.651" width="0.1524" layer="47"/>
<wire x1="10.033" y1="1.651" x2="10.287" y2="1.651" width="0.1524" layer="47"/>
<wire x1="10.16" y1="-19.685" x2="10.033" y2="-19.431" width="0.1524" layer="47"/>
<wire x1="10.16" y1="-19.685" x2="10.287" y2="-19.431" width="0.1524" layer="47"/>
<wire x1="10.033" y1="-19.431" x2="10.287" y2="-19.431" width="0.1524" layer="47"/>
<text x="-9.6647" y="-24.892" size="1.27" layer="47" ratio="6">Default Padstyle: c152h81</text>
<text x="-8.8849" y="-27.432" size="1.27" layer="47" ratio="6">Pin 1 Padstyle: s152h81</text>
<text x="-11.0036" y="-28.702" size="1.27" layer="47" ratio="6">Alt 1 Padstyle: b152_229h76</text>
<text x="-11.0036" y="-29.972" size="1.27" layer="47" ratio="6">Alt 2 Padstyle: b229_152h76</text>
<text x="-9.404" y="-1.5875" size="0.635" layer="47" ratio="4">0.1in/2.54mm</text>
<text x="0.632" y="-21.463" size="0.635" layer="47" ratio="4">0.3in/7.62mm</text>
<text x="0.0557" y="3.048" size="0.635" layer="47" ratio="4">0.22in/5.588mm</text>
<text x="10.668" y="-9.2075" size="0.635" layer="47" ratio="4">0.85in/21.59mm</text>
<wire x1="0.889" y1="-19.812" x2="6.731" y2="-19.812" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-19.812" x2="6.731" y2="-18.4189" width="0.1524" layer="21"/>
<wire x1="6.731" y1="2.032" x2="0.889" y2="2.032" width="0.1524" layer="21"/>
<wire x1="0.889" y1="2.032" x2="0.889" y2="1.0695" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-1.0695" x2="0.889" y2="-1.9011" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-3.1789" x2="0.889" y2="-4.4411" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-5.7189" x2="0.889" y2="-6.9811" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-8.2589" x2="0.889" y2="-9.5211" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-10.7989" x2="0.889" y2="-12.0611" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-13.3389" x2="0.889" y2="-14.6011" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-15.8789" x2="0.889" y2="-17.1411" width="0.1524" layer="21"/>
<wire x1="0.889" y1="-18.4189" x2="0.889" y2="-19.812" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-17.1411" x2="6.731" y2="-15.8789" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-14.6011" x2="6.731" y2="-13.3389" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-12.0611" x2="6.731" y2="-10.7989" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-9.5211" x2="6.731" y2="-8.2589" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-6.9811" x2="6.731" y2="-5.7189" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-4.4411" x2="6.731" y2="-3.1789" width="0.1524" layer="21"/>
<wire x1="6.731" y1="-1.9011" x2="6.731" y2="-0.6389" width="0.1524" layer="21"/>
<wire x1="6.731" y1="0.6389" x2="6.731" y2="2.032" width="0.1524" layer="21"/>
<text x="-0.5763" y="0.889" size="1.27" layer="21" ratio="6">*</text>
<text x="2.0812" y="-9.525" size="1.27" layer="21" ratio="6">&gt;Value</text>
<wire x1="1.016" y1="-0.4064" x2="1.016" y2="0.4064" width="0.1524" layer="51"/>
<wire x1="1.016" y1="0.4064" x2="-0.4064" y2="0.4064" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="0.4064" x2="-0.4064" y2="-0.4064" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-0.4064" x2="1.016" y2="-0.4064" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-2.9464" x2="1.016" y2="-2.1336" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-2.1336" x2="-0.4064" y2="-2.1336" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-2.1336" x2="-0.4064" y2="-2.9464" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-2.9464" x2="1.016" y2="-2.9464" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-5.4864" x2="1.016" y2="-4.6736" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-4.6736" x2="-0.4064" y2="-4.6736" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-4.6736" x2="-0.4064" y2="-5.4864" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-5.4864" x2="1.016" y2="-5.4864" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-8.0264" x2="1.016" y2="-7.2136" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-7.2136" x2="-0.4064" y2="-7.2136" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-7.2136" x2="-0.4064" y2="-8.0264" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-8.0264" x2="1.016" y2="-8.0264" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-10.5664" x2="1.016" y2="-9.7536" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-9.7536" x2="-0.4064" y2="-9.7536" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-9.7536" x2="-0.4064" y2="-10.5664" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-10.5664" x2="1.016" y2="-10.5664" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-13.1064" x2="1.016" y2="-12.2936" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-12.2936" x2="-0.4064" y2="-12.2936" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-12.2936" x2="-0.4064" y2="-13.1064" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-13.1064" x2="1.016" y2="-13.1064" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-15.6464" x2="1.016" y2="-14.8336" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-14.8336" x2="-0.4064" y2="-14.8336" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-14.8336" x2="-0.4064" y2="-15.6464" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-15.6464" x2="1.016" y2="-15.6464" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-18.1864" x2="1.016" y2="-17.3736" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-17.3736" x2="-0.4064" y2="-17.3736" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-17.3736" x2="-0.4064" y2="-18.1864" width="0.1524" layer="51"/>
<wire x1="-0.4064" y1="-18.1864" x2="1.016" y2="-18.1864" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-17.3736" x2="6.604" y2="-18.1864" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-18.1864" x2="8.0264" y2="-18.1864" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-18.1864" x2="8.0264" y2="-17.3736" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-17.3736" x2="6.604" y2="-17.3736" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-14.8336" x2="6.604" y2="-15.6464" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-15.6464" x2="8.0264" y2="-15.6464" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-15.6464" x2="8.0264" y2="-14.8336" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-14.8336" x2="6.604" y2="-14.8336" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-12.2936" x2="6.604" y2="-13.1064" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-13.1064" x2="8.0264" y2="-13.1064" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-13.1064" x2="8.0264" y2="-12.2936" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-12.2936" x2="6.604" y2="-12.2936" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-9.7536" x2="6.604" y2="-10.5664" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-10.5664" x2="8.0264" y2="-10.5664" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-10.5664" x2="8.0264" y2="-9.7536" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-9.7536" x2="6.604" y2="-9.7536" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-7.2136" x2="6.604" y2="-8.0264" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-8.0264" x2="8.0264" y2="-8.0264" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-8.0264" x2="8.0264" y2="-7.2136" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-7.2136" x2="6.604" y2="-7.2136" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-4.6736" x2="6.604" y2="-5.4864" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-5.4864" x2="8.0264" y2="-5.4864" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-5.4864" x2="8.0264" y2="-4.6736" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-4.6736" x2="6.604" y2="-4.6736" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-2.1336" x2="6.604" y2="-2.9464" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-2.9464" x2="8.0264" y2="-2.9464" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-2.9464" x2="8.0264" y2="-2.1336" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-2.1336" x2="6.604" y2="-2.1336" width="0.1524" layer="51"/>
<wire x1="6.604" y1="0.4064" x2="6.604" y2="-0.4064" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-0.4064" x2="8.0264" y2="-0.4064" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="-0.4064" x2="8.0264" y2="0.4064" width="0.1524" layer="51"/>
<wire x1="8.0264" y1="0.4064" x2="6.604" y2="0.4064" width="0.1524" layer="51"/>
<wire x1="1.016" y1="-19.685" x2="6.604" y2="-19.685" width="0.1524" layer="51"/>
<wire x1="6.604" y1="-19.685" x2="6.604" y2="1.905" width="0.1524" layer="51"/>
<wire x1="6.604" y1="1.905" x2="1.016" y2="1.905" width="0.1524" layer="51"/>
<wire x1="1.016" y1="1.905" x2="1.016" y2="-19.685" width="0.1524" layer="51"/>
<wire x1="4.1148" y1="1.905" x2="3.5052" y2="1.905" width="0.1524" layer="51" curve="-180"/>
<text x="0.6937" y="-0.635" size="1.27" layer="51" ratio="6">*</text>
<text x="0.5388" y="-9.525" size="1.27" layer="27" ratio="6">&gt;Name</text>
</package>
</packages>
<symbols>
<symbol name="MCP3008-I/P">
<pin name="1" x="2.54" y="0" length="middle" direction="pas"/>
<pin name="2" x="2.54" y="-2.54" length="middle" direction="pas"/>
<pin name="3" x="2.54" y="-5.08" length="middle" direction="pas"/>
<pin name="4" x="2.54" y="-7.62" length="middle" direction="pas"/>
<pin name="5" x="2.54" y="-10.16" length="middle" direction="pas"/>
<pin name="6" x="2.54" y="-12.7" length="middle" direction="pas"/>
<pin name="7" x="2.54" y="-15.24" length="middle" direction="pas"/>
<pin name="8" x="2.54" y="-17.78" length="middle" direction="pas"/>
<pin name="9" x="48.26" y="-17.78" length="middle" direction="pas" rot="R180"/>
<pin name="10" x="48.26" y="-15.24" length="middle" direction="pas" rot="R180"/>
<pin name="11" x="48.26" y="-12.7" length="middle" direction="pas" rot="R180"/>
<pin name="12" x="48.26" y="-10.16" length="middle" direction="pas" rot="R180"/>
<pin name="13" x="48.26" y="-7.62" length="middle" direction="pas" rot="R180"/>
<pin name="14" x="48.26" y="-5.08" length="middle" direction="pas" rot="R180"/>
<pin name="15" x="48.26" y="-2.54" length="middle" direction="pas" rot="R180"/>
<pin name="16" x="48.26" y="0" length="middle" direction="pas" rot="R180"/>
<wire x1="7.62" y1="5.08" x2="7.62" y2="-22.86" width="0.1524" layer="94"/>
<wire x1="7.62" y1="-22.86" x2="43.18" y2="-22.86" width="0.1524" layer="94"/>
<wire x1="43.18" y1="-22.86" x2="43.18" y2="5.08" width="0.1524" layer="94"/>
<wire x1="43.18" y1="5.08" x2="7.62" y2="5.08" width="0.1524" layer="94"/>
<text x="20.6746" y="9.1186" size="2.083" layer="95" ratio="6">&gt;Name</text>
<text x="20.0352" y="6.5786" size="2.083" layer="96" ratio="6">&gt;Value</text>
</symbol>
</symbols>
<devicesets>
<deviceset name="MCP3008-I/P" prefix="U">
<gates>
<gate name="A" symbol="MCP3008-I/P" x="0" y="0"/>
</gates>
<devices>
<device name="PDIP16_300MC_MCH" package="PDIP16_300MC_MCH">
<connects>
<connect gate="A" pin="1" pad="1"/>
<connect gate="A" pin="10" pad="10"/>
<connect gate="A" pin="11" pad="11"/>
<connect gate="A" pin="12" pad="12"/>
<connect gate="A" pin="13" pad="13"/>
<connect gate="A" pin="14" pad="14"/>
<connect gate="A" pin="15" pad="15"/>
<connect gate="A" pin="16" pad="16"/>
<connect gate="A" pin="2" pad="2"/>
<connect gate="A" pin="3" pad="3"/>
<connect gate="A" pin="4" pad="4"/>
<connect gate="A" pin="5" pad="5"/>
<connect gate="A" pin="6" pad="6"/>
<connect gate="A" pin="7" pad="7"/>
<connect gate="A" pin="8" pad="8"/>
<connect gate="A" pin="9" pad="9"/>
</connects>
<technologies>
<technology name="">
<attribute name="COPYRIGHT" value="Copyright (C) 2022 Ultra Librarian. All rights reserved." constant="no"/>
<attribute name="DIGI-KEY_PART_NUMBER_1" value="MCP3008-I/P-ND" constant="no"/>
<attribute name="MANUFACTURER_PART_NUMBER" value="MCP3008-I/P" constant="no"/>
<attribute name="MFR_NAME" value="Microchip" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="con-samtec" urn="urn:adsk.eagle:library:184">
<description>&lt;b&gt;Samtec Connectors&lt;/b&gt;&lt;p&gt;
&lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;</description>
<packages>
<package name="TSW-113-XX-G-S" library_version="2">
<description>&lt;b&gt;THROUGH-HOLE .025" SQ POST HEADER&lt;/b&gt;&lt;p&gt;
Source: Samtec TSW.pdf</description>
<wire x1="-16.639" y1="1.155" x2="16.639" y2="1.155" width="0.2032" layer="21"/>
<wire x1="16.639" y1="1.155" x2="16.639" y2="-1.155" width="0.2032" layer="21"/>
<wire x1="16.639" y1="-1.155" x2="-16.639" y2="-1.155" width="0.2032" layer="21"/>
<wire x1="-16.639" y1="-1.155" x2="-16.639" y2="1.155" width="0.2032" layer="21"/>
<pad name="1" x="15.24" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="2" x="12.7" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="3" x="10.16" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="4" x="7.62" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="5" x="5.08" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="6" x="2.54" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="7" x="0" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="8" x="-2.54" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="9" x="-5.08" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="10" x="-7.62" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="11" x="-10.16" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="12" x="-12.7" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="13" x="-15.24" y="0" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<text x="14.982" y="-2.498" size="1.1" layer="21" font="vector" rot="SR0">1</text>
<text x="-17.145" y="-1.27" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="18.415" y="-1.27" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-15.59" y1="-0.35" x2="-14.89" y2="0.35" layer="51"/>
<rectangle x1="-13.05" y1="-0.35" x2="-12.35" y2="0.35" layer="51"/>
<rectangle x1="-10.51" y1="-0.35" x2="-9.81" y2="0.35" layer="51"/>
<rectangle x1="-7.97" y1="-0.35" x2="-7.27" y2="0.35" layer="51"/>
<rectangle x1="-5.43" y1="-0.35" x2="-4.73" y2="0.35" layer="51"/>
<rectangle x1="-2.89" y1="-0.35" x2="-2.19" y2="0.35" layer="51"/>
<rectangle x1="-0.35" y1="-0.35" x2="0.35" y2="0.35" layer="51"/>
<rectangle x1="2.19" y1="-0.35" x2="2.89" y2="0.35" layer="51"/>
<rectangle x1="4.73" y1="-0.35" x2="5.43" y2="0.35" layer="51"/>
<rectangle x1="7.27" y1="-0.35" x2="7.97" y2="0.35" layer="51"/>
<rectangle x1="9.81" y1="-0.35" x2="10.51" y2="0.35" layer="51"/>
<rectangle x1="12.35" y1="-0.35" x2="13.05" y2="0.35" layer="51"/>
<rectangle x1="14.89" y1="-0.35" x2="15.59" y2="0.35" layer="51"/>
</package>
<package name="TSW-113-08-G-S-RA" library_version="2">
<description>&lt;b&gt;THROUGH-HOLE .025" SQ POST HEADER&lt;/b&gt;&lt;p&gt;
Source: Samtec TSW.pdf</description>
<wire x1="-16.639" y1="-2.046" x2="16.639" y2="-2.046" width="0.2032" layer="21"/>
<wire x1="16.639" y1="-2.046" x2="16.639" y2="-0.106" width="0.2032" layer="21"/>
<wire x1="16.639" y1="-0.106" x2="-16.639" y2="-0.106" width="0.2032" layer="21"/>
<wire x1="-16.639" y1="-0.106" x2="-16.639" y2="-2.046" width="0.2032" layer="21"/>
<pad name="1" x="15.24" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="2" x="12.7" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="3" x="10.16" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="4" x="7.62" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="5" x="5.08" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="6" x="2.54" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="7" x="0" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="8" x="-2.54" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="9" x="-5.08" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="10" x="-7.62" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="11" x="-10.16" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="12" x="-12.7" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<pad name="13" x="-15.24" y="1.524" drill="1" diameter="1.5" shape="octagon" rot="R180"/>
<text x="-17.145" y="-7.62" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="18.415" y="-7.62" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<text x="16.522" y="1.152" size="1.1" layer="21" font="vector" rot="SR0">1</text>
<rectangle x1="-15.494" y1="0" x2="-14.986" y2="1.778" layer="51"/>
<rectangle x1="-12.954" y1="0" x2="-12.446" y2="1.778" layer="51"/>
<rectangle x1="-10.414" y1="0" x2="-9.906" y2="1.778" layer="51"/>
<rectangle x1="-7.874" y1="0" x2="-7.366" y2="1.778" layer="51"/>
<rectangle x1="-5.334" y1="0" x2="-4.826" y2="1.778" layer="51"/>
<rectangle x1="-2.794" y1="0" x2="-2.286" y2="1.778" layer="51"/>
<rectangle x1="-0.254" y1="0" x2="0.254" y2="1.778" layer="51"/>
<rectangle x1="2.286" y1="0" x2="2.794" y2="1.778" layer="51"/>
<rectangle x1="4.826" y1="0" x2="5.334" y2="1.778" layer="51"/>
<rectangle x1="7.366" y1="0" x2="7.874" y2="1.778" layer="51"/>
<rectangle x1="9.906" y1="0" x2="10.414" y2="1.778" layer="51"/>
<rectangle x1="12.446" y1="0" x2="12.954" y2="1.778" layer="51"/>
<rectangle x1="14.986" y1="0" x2="15.494" y2="1.778" layer="51"/>
<rectangle x1="-15.494" y1="-7.89" x2="-14.986" y2="-2.04" layer="21"/>
<rectangle x1="-12.954" y1="-7.89" x2="-12.446" y2="-2.04" layer="21"/>
<rectangle x1="-10.414" y1="-7.89" x2="-9.906" y2="-2.04" layer="21"/>
<rectangle x1="-7.874" y1="-7.89" x2="-7.366" y2="-2.04" layer="21"/>
<rectangle x1="-5.334" y1="-7.89" x2="-4.826" y2="-2.04" layer="21"/>
<rectangle x1="-2.794" y1="-7.89" x2="-2.286" y2="-2.04" layer="21"/>
<rectangle x1="-0.254" y1="-7.89" x2="0.254" y2="-2.04" layer="21"/>
<rectangle x1="2.286" y1="-7.89" x2="2.794" y2="-2.04" layer="21"/>
<rectangle x1="4.826" y1="-7.89" x2="5.334" y2="-2.04" layer="21"/>
<rectangle x1="7.366" y1="-7.89" x2="7.874" y2="-2.04" layer="21"/>
<rectangle x1="9.906" y1="-7.89" x2="10.414" y2="-2.04" layer="21"/>
<rectangle x1="12.446" y1="-7.89" x2="12.954" y2="-2.04" layer="21"/>
<rectangle x1="14.986" y1="-7.89" x2="15.494" y2="-2.04" layer="21"/>
</package>
</packages>
<symbols>
<symbol name="MPINV" library_version="2">
<text x="-1.27" y="1.27" size="1.778" layer="96">&gt;VALUE</text>
<text x="2.54" y="-0.762" size="1.524" layer="95">&gt;NAME</text>
<rectangle x1="0" y1="-0.254" x2="1.778" y2="0.254" layer="94"/>
<pin name="1" x="-2.54" y="0" visible="off" length="short" direction="pas"/>
</symbol>
<symbol name="MPIN" library_version="2">
<text x="2.54" y="-0.762" size="1.524" layer="95">&gt;NAME</text>
<rectangle x1="0" y1="-0.254" x2="1.778" y2="0.254" layer="94"/>
<pin name="1" x="-2.54" y="0" visible="off" length="short" direction="pas"/>
</symbol>
</symbols>
<devicesets>
<deviceset name="TSW-113-*-G-S" prefix="X" library_version="2">
<description>&lt;b&gt;THROUGH-HOLE .025" SQ POST HEADER&lt;/b&gt;&lt;p&gt;
Source: Samtec TSW.pdf</description>
<gates>
<gate name="-1" symbol="MPINV" x="-1.27" y="15.24" addlevel="always"/>
<gate name="-2" symbol="MPIN" x="-1.27" y="12.7" addlevel="always"/>
<gate name="-3" symbol="MPIN" x="-1.27" y="10.16" addlevel="always"/>
<gate name="-4" symbol="MPIN" x="-1.27" y="7.62" addlevel="always"/>
<gate name="-5" symbol="MPIN" x="-1.27" y="5.08" addlevel="always"/>
<gate name="-6" symbol="MPIN" x="-1.27" y="2.54" addlevel="always"/>
<gate name="-7" symbol="MPIN" x="-1.27" y="0" addlevel="always"/>
<gate name="-8" symbol="MPIN" x="-1.27" y="-2.54" addlevel="always"/>
<gate name="-9" symbol="MPIN" x="-1.27" y="-5.08" addlevel="always"/>
<gate name="-10" symbol="MPIN" x="-1.27" y="-7.62" addlevel="always"/>
<gate name="-11" symbol="MPIN" x="-1.27" y="-10.16" addlevel="always"/>
<gate name="-12" symbol="MPIN" x="-1.27" y="-12.7" addlevel="always"/>
<gate name="-13" symbol="MPIN" x="-1.27" y="-15.24" addlevel="always"/>
</gates>
<devices>
<device name="" package="TSW-113-XX-G-S">
<connects>
<connect gate="-1" pin="1" pad="1"/>
<connect gate="-10" pin="1" pad="10"/>
<connect gate="-11" pin="1" pad="11"/>
<connect gate="-12" pin="1" pad="12"/>
<connect gate="-13" pin="1" pad="13"/>
<connect gate="-2" pin="1" pad="2"/>
<connect gate="-3" pin="1" pad="3"/>
<connect gate="-4" pin="1" pad="4"/>
<connect gate="-5" pin="1" pad="5"/>
<connect gate="-6" pin="1" pad="6"/>
<connect gate="-7" pin="1" pad="7"/>
<connect gate="-8" pin="1" pad="8"/>
<connect gate="-9" pin="1" pad="9"/>
</connects>
<technologies>
<technology name="07">
<attribute name="MF" value="Samtec Inc." constant="no"/>
<attribute name="MPN" value="TSW-113-07-G-S" constant="no"/>
<attribute name="OC_FARNELL" value="" constant="no"/>
<attribute name="OC_NEWARK" value="" constant="no"/>
</technology>
<technology name="08">
<attribute name="MF" value="Samtec Inc." constant="no"/>
<attribute name="MPN" value="TSW-113-07-G-S" constant="no"/>
<attribute name="OC_FARNELL" value="" constant="no"/>
<attribute name="OC_NEWARK" value="" constant="no"/>
</technology>
</technologies>
</device>
<device name="-S-RA" package="TSW-113-08-G-S-RA">
<connects>
<connect gate="-1" pin="1" pad="1"/>
<connect gate="-10" pin="1" pad="10"/>
<connect gate="-11" pin="1" pad="11"/>
<connect gate="-12" pin="1" pad="12"/>
<connect gate="-13" pin="1" pad="13"/>
<connect gate="-2" pin="1" pad="2"/>
<connect gate="-3" pin="1" pad="3"/>
<connect gate="-4" pin="1" pad="4"/>
<connect gate="-5" pin="1" pad="5"/>
<connect gate="-6" pin="1" pad="6"/>
<connect gate="-7" pin="1" pad="7"/>
<connect gate="-8" pin="1" pad="8"/>
<connect gate="-9" pin="1" pad="9"/>
</connects>
<technologies>
<technology name="08">
<attribute name="MF" value="Samtec Inc." constant="no"/>
<attribute name="MPN" value="TSW-113-08-G-S-RA" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
</libraries>
<attributes>
</attributes>
<variantdefs>
</variantdefs>
<classes>
<class number="0" name="default" width="0" drill="0">
</class>
</classes>
<parts>
<part name="ON/OFF" library="led" library_urn="urn:adsk.eagle:library:259" deviceset="LED" device="5MM" package3d_urn="urn:adsk.eagle:package:15799/2"/>
<part name="MODE1" library="led" library_urn="urn:adsk.eagle:library:259" deviceset="LED" device="5MM" package3d_urn="urn:adsk.eagle:package:15799/2"/>
<part name="MODE2" library="led" library_urn="urn:adsk.eagle:library:259" deviceset="LED" device="5MM" package3d_urn="urn:adsk.eagle:package:15799/2"/>
<part name="MODE3" library="led" library_urn="urn:adsk.eagle:library:259" deviceset="LED" device="5MM" package3d_urn="urn:adsk.eagle:package:15799/2"/>
<part name="MODE4" library="led" library_urn="urn:adsk.eagle:library:259" deviceset="LED" device="5MM" package3d_urn="urn:adsk.eagle:package:15799/2"/>
<part name="GND1" library="supply1" library_urn="urn:adsk.eagle:library:371" deviceset="GND" device=""/>
<part name="GND2" library="supply1" library_urn="urn:adsk.eagle:library:371" deviceset="GND" device=""/>
<part name="GND3" library="supply1" library_urn="urn:adsk.eagle:library:371" deviceset="GND" device=""/>
<part name="GND4" library="supply1" library_urn="urn:adsk.eagle:library:371" deviceset="GND" device=""/>
<part name="GND5" library="supply1" library_urn="urn:adsk.eagle:library:371" deviceset="GND" device=""/>
<part name="U3" library="2022-10-25_19-15-06_Library" deviceset="SC0915" device="SC0915_RPI"/>
<part name="U2" library="2022-10-25_19-18-53_Library" deviceset="MCP3008-I/P" device="PDIP16_300MC_MCH"/>
<part name="BUTTON" library="con-samtec" library_urn="urn:adsk.eagle:library:184" deviceset="TSW-113-*-G-S" device="" technology="07"/>
<part name="GND" library="con-samtec" library_urn="urn:adsk.eagle:library:184" deviceset="TSW-113-*-G-S" device="" technology="07"/>
</parts>
<sheets>
<sheet>
<plain>
</plain>
<instances>
<instance part="ON/OFF" gate="G$1" x="7.62" y="-7.62" smashed="yes">
<attribute name="NAME" x="11.176" y="-12.192" size="1.778" layer="95" rot="R90"/>
<attribute name="VALUE" x="13.335" y="-12.192" size="1.778" layer="96" rot="R90"/>
</instance>
<instance part="MODE1" gate="G$1" x="17.78" y="-7.62" smashed="yes">
<attribute name="NAME" x="21.336" y="-12.192" size="1.778" layer="95" rot="R90"/>
<attribute name="VALUE" x="23.495" y="-12.192" size="1.778" layer="96" rot="R90"/>
</instance>
<instance part="MODE2" gate="G$1" x="27.94" y="-7.62" smashed="yes">
<attribute name="NAME" x="31.496" y="-12.192" size="1.778" layer="95" rot="R90"/>
<attribute name="VALUE" x="33.655" y="-12.192" size="1.778" layer="96" rot="R90"/>
</instance>
<instance part="MODE3" gate="G$1" x="38.1" y="-7.62" smashed="yes">
<attribute name="NAME" x="41.656" y="-12.192" size="1.778" layer="95" rot="R90"/>
<attribute name="VALUE" x="43.815" y="-12.192" size="1.778" layer="96" rot="R90"/>
</instance>
<instance part="MODE4" gate="G$1" x="48.26" y="-7.62" smashed="yes">
<attribute name="NAME" x="51.816" y="-12.192" size="1.778" layer="95" rot="R90"/>
<attribute name="VALUE" x="53.975" y="-12.192" size="1.778" layer="96" rot="R90"/>
</instance>
<instance part="GND1" gate="1" x="7.62" y="-22.86" smashed="yes">
<attribute name="VALUE" x="5.08" y="-25.4" size="1.778" layer="96"/>
</instance>
<instance part="GND2" gate="1" x="17.78" y="-22.86" smashed="yes">
<attribute name="VALUE" x="15.24" y="-25.4" size="1.778" layer="96"/>
</instance>
<instance part="GND3" gate="1" x="27.94" y="-22.86" smashed="yes">
<attribute name="VALUE" x="25.4" y="-25.4" size="1.778" layer="96"/>
</instance>
<instance part="GND4" gate="1" x="38.1" y="-22.86" smashed="yes">
<attribute name="VALUE" x="35.56" y="-25.4" size="1.778" layer="96"/>
</instance>
<instance part="GND5" gate="1" x="48.26" y="-22.86" smashed="yes">
<attribute name="VALUE" x="45.72" y="-25.4" size="1.778" layer="96"/>
</instance>
<instance part="U3" gate="A" x="104.14" y="58.42" smashed="yes">
<attribute name="NAME" x="162.9146" y="67.5386" size="2.083" layer="95" ratio="6"/>
<attribute name="VALUE" x="162.2752" y="64.9986" size="2.083" layer="96" ratio="6"/>
</instance>
<instance part="U2" gate="A" x="5.08" y="40.64" smashed="yes">
<attribute name="NAME" x="25.7546" y="49.7586" size="2.083" layer="95" ratio="6"/>
<attribute name="VALUE" x="25.1152" y="47.2186" size="2.083" layer="96" ratio="6"/>
</instance>
<instance part="BUTTON" gate="-1" x="179.07" y="-17.78" smashed="yes">
<attribute name="VALUE" x="177.8" y="-13.97" size="1.778" layer="96"/>
<attribute name="NAME" x="181.61" y="-18.542" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-2" x="179.07" y="-20.32" smashed="yes">
<attribute name="NAME" x="181.61" y="-21.082" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-3" x="179.07" y="-22.86" smashed="yes">
<attribute name="NAME" x="181.61" y="-23.622" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-4" x="179.07" y="-25.4" smashed="yes">
<attribute name="NAME" x="181.61" y="-26.162" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-5" x="179.07" y="-27.94" smashed="yes">
<attribute name="NAME" x="181.61" y="-28.702" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-6" x="179.07" y="-30.48" smashed="yes">
<attribute name="NAME" x="181.61" y="-31.242" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-7" x="179.07" y="-33.02" smashed="yes">
<attribute name="NAME" x="181.61" y="-33.782" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-8" x="179.07" y="-35.56" smashed="yes">
<attribute name="NAME" x="181.61" y="-36.322" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-9" x="179.07" y="-38.1" smashed="yes">
<attribute name="NAME" x="181.61" y="-38.862" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-10" x="179.07" y="-40.64" smashed="yes">
<attribute name="NAME" x="181.61" y="-41.402" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-11" x="179.07" y="-43.18" smashed="yes">
<attribute name="NAME" x="181.61" y="-43.942" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-12" x="179.07" y="-45.72" smashed="yes">
<attribute name="NAME" x="181.61" y="-46.482" size="1.524" layer="95"/>
</instance>
<instance part="BUTTON" gate="-13" x="179.07" y="-48.26" smashed="yes">
<attribute name="NAME" x="181.61" y="-49.022" size="1.524" layer="95"/>
</instance>
<instance part="GND" gate="-1" x="214.63" y="-48.26" smashed="yes" rot="R180">
<attribute name="VALUE" x="215.9" y="-49.53" size="1.778" layer="96" rot="R180"/>
<attribute name="NAME" x="212.09" y="-47.498" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-2" x="214.63" y="-45.72" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-44.958" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-3" x="214.63" y="-43.18" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-42.418" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-4" x="214.63" y="-40.64" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-39.878" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-5" x="214.63" y="-38.1" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-37.338" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-6" x="214.63" y="-35.56" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-34.798" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-7" x="214.63" y="-33.02" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-32.258" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-8" x="214.63" y="-30.48" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-29.718" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-9" x="214.63" y="-27.94" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-27.178" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-10" x="214.63" y="-25.4" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-24.638" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-11" x="214.63" y="-22.86" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-22.098" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-12" x="214.63" y="-20.32" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-19.558" size="1.524" layer="95" rot="R180"/>
</instance>
<instance part="GND" gate="-13" x="214.63" y="-17.78" smashed="yes" rot="R180">
<attribute name="NAME" x="212.09" y="-17.018" size="1.524" layer="95" rot="R180"/>
</instance>
</instances>
<busses>
</busses>
<nets>
<net name="RIGHTSTICKY" class="0">
<segment>
<pinref part="U2" gate="A" pin="7"/>
<wire x1="7.62" y1="25.4" x2="-5.08" y2="25.4" width="0.1524" layer="91"/>
<label x="-10.16" y="25.4" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="LEFTSTICKY" class="0">
<segment>
<pinref part="U2" gate="A" pin="4"/>
<wire x1="7.62" y1="33.02" x2="-5.08" y2="33.02" width="0.1524" layer="91"/>
<label x="-10.16" y="33.02" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="N$9" class="0">
<segment>
<pinref part="U3" gate="A" pin="I2C1_SDA/SPI0_SCK/GP6"/>
<wire x1="106.68" y1="38.1" x2="73.66" y2="27.94" width="0.1524" layer="91"/>
<wire x1="73.66" y1="27.94" x2="73.66" y2="-43.18" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-11" pin="1"/>
<wire x1="176.53" y1="-43.18" x2="73.66" y2="-43.18" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$10" class="0">
<segment>
<pinref part="U3" gate="A" pin="I2C1_SCL/SPI0_TX/GP7"/>
<wire x1="106.68" y1="35.56" x2="76.2" y2="25.4" width="0.1524" layer="91"/>
<wire x1="76.2" y1="25.4" x2="76.2" y2="-40.64" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-10" pin="1"/>
<wire x1="176.53" y1="-40.64" x2="76.2" y2="-40.64" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$11" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART1_TX/I2C0_SDA/SPI1_RX/GP8"/>
<wire x1="106.68" y1="33.02" x2="78.74" y2="22.86" width="0.1524" layer="91"/>
<wire x1="78.74" y1="22.86" x2="78.74" y2="-38.1" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-9" pin="1"/>
<wire x1="78.74" y1="-38.1" x2="176.53" y2="-38.1" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$12" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART1_RX/I2C0_SCL/SPI1_CSN/GP9"/>
<wire x1="106.68" y1="30.48" x2="81.28" y2="20.32" width="0.1524" layer="91"/>
<wire x1="81.28" y1="20.32" x2="81.28" y2="-35.56" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-8" pin="1"/>
<wire x1="176.53" y1="-35.56" x2="81.28" y2="-35.56" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$13" class="0">
<segment>
<pinref part="U3" gate="A" pin="I2C1_SDA/SPI1_SCK/GP10"/>
<wire x1="106.68" y1="25.4" x2="83.82" y2="15.24" width="0.1524" layer="91"/>
<wire x1="83.82" y1="15.24" x2="83.82" y2="-33.02" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-7" pin="1"/>
<wire x1="176.53" y1="-33.02" x2="83.82" y2="-33.02" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$14" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART0_TX/I2C0_SDA/GPI1_RX/GP12"/>
<wire x1="106.68" y1="20.32" x2="86.36" y2="10.16" width="0.1524" layer="91"/>
<wire x1="86.36" y1="10.16" x2="86.36" y2="-30.48" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-6" pin="1"/>
<wire x1="176.53" y1="-30.48" x2="86.36" y2="-30.48" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$15" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART0_RX/I2C0_SCL/SPI1_CSN/GP13"/>
<wire x1="106.68" y1="17.78" x2="88.9" y2="7.62" width="0.1524" layer="91"/>
<wire x1="88.9" y1="7.62" x2="88.9" y2="-27.94" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-5" pin="1"/>
<wire x1="176.53" y1="-27.94" x2="88.9" y2="-27.94" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$16" class="0">
<segment>
<pinref part="U3" gate="A" pin="I2C1_SDA/SPI1_SCK/GP14"/>
<wire x1="106.68" y1="12.7" x2="91.44" y2="5.08" width="0.1524" layer="91"/>
<wire x1="91.44" y1="5.08" x2="91.44" y2="-25.4" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-4" pin="1"/>
<wire x1="176.53" y1="-25.4" x2="91.44" y2="-25.4" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$17" class="0">
<segment>
<pinref part="U3" gate="A" pin="I2C1_SCL/SPI1_TX/GP15"/>
<wire x1="106.68" y1="10.16" x2="93.98" y2="2.54" width="0.1524" layer="91"/>
<wire x1="93.98" y1="2.54" x2="93.98" y2="-22.86" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-3" pin="1"/>
<wire x1="176.53" y1="-22.86" x2="93.98" y2="-22.86" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$18" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART0_TX/I2C0_SDA/SPI0_RX/GP16"/>
<wire x1="106.68" y1="7.62" x2="96.52" y2="2.54" width="0.1524" layer="91"/>
<wire x1="96.52" y1="2.54" x2="96.52" y2="-20.32" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-2" pin="1"/>
<wire x1="176.53" y1="-20.32" x2="96.52" y2="-20.32" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$19" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART0_RX/I2C0_SCL/SPI0_CSN/GP17"/>
<wire x1="106.68" y1="5.08" x2="99.06" y2="0" width="0.1524" layer="91"/>
<wire x1="99.06" y1="0" x2="99.06" y2="-17.78" width="0.1524" layer="91"/>
<pinref part="BUTTON" gate="-1" pin="1"/>
<wire x1="176.53" y1="-17.78" x2="99.06" y2="-17.78" width="0.1524" layer="91"/>
</segment>
</net>
<net name="GND" class="0">
<segment>
<pinref part="U3" gate="A" pin="GND_7"/>
<wire x1="233.68" y1="-22.86" x2="233.68" y2="-20.32" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-20.32" x2="233.68" y2="-17.78" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-17.78" x2="233.68" y2="-5.08" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-5.08" x2="228.6" y2="-5.08" width="0.1524" layer="91"/>
<pinref part="GND" gate="-3" pin="1"/>
<wire x1="217.17" y1="-43.18" x2="233.68" y2="-43.18" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-43.18" x2="233.68" y2="-40.64" width="0.1524" layer="91"/>
<pinref part="GND" gate="-4" pin="1"/>
<wire x1="233.68" y1="-40.64" x2="233.68" y2="-38.1" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-38.1" x2="233.68" y2="-35.56" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-35.56" x2="233.68" y2="-33.02" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-33.02" x2="233.68" y2="-30.48" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-30.48" x2="233.68" y2="-27.94" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-27.94" x2="233.68" y2="-25.4" width="0.1524" layer="91"/>
<wire x1="233.68" y1="-25.4" x2="233.68" y2="-22.86" width="0.1524" layer="91"/>
<wire x1="217.17" y1="-40.64" x2="233.68" y2="-40.64" width="0.1524" layer="91"/>
<junction x="233.68" y="-40.64"/>
<pinref part="GND" gate="-5" pin="1"/>
<wire x1="217.17" y1="-38.1" x2="233.68" y2="-38.1" width="0.1524" layer="91"/>
<junction x="233.68" y="-38.1"/>
<pinref part="GND" gate="-6" pin="1"/>
<wire x1="217.17" y1="-35.56" x2="233.68" y2="-35.56" width="0.1524" layer="91"/>
<junction x="233.68" y="-35.56"/>
<pinref part="GND" gate="-7" pin="1"/>
<wire x1="217.17" y1="-33.02" x2="233.68" y2="-33.02" width="0.1524" layer="91"/>
<junction x="233.68" y="-33.02"/>
<pinref part="GND" gate="-8" pin="1"/>
<wire x1="217.17" y1="-30.48" x2="233.68" y2="-30.48" width="0.1524" layer="91"/>
<junction x="233.68" y="-30.48"/>
<pinref part="GND" gate="-9" pin="1"/>
<wire x1="217.17" y1="-27.94" x2="233.68" y2="-27.94" width="0.1524" layer="91"/>
<junction x="233.68" y="-27.94"/>
<pinref part="GND" gate="-10" pin="1"/>
<wire x1="217.17" y1="-25.4" x2="233.68" y2="-25.4" width="0.1524" layer="91"/>
<junction x="233.68" y="-25.4"/>
<pinref part="GND" gate="-11" pin="1"/>
<wire x1="217.17" y1="-22.86" x2="233.68" y2="-22.86" width="0.1524" layer="91"/>
<junction x="233.68" y="-22.86"/>
<pinref part="GND" gate="-12" pin="1"/>
<wire x1="217.17" y1="-20.32" x2="233.68" y2="-20.32" width="0.1524" layer="91"/>
<junction x="233.68" y="-20.32"/>
<pinref part="GND" gate="-13" pin="1"/>
<wire x1="217.17" y1="-17.78" x2="233.68" y2="-17.78" width="0.1524" layer="91"/>
<junction x="233.68" y="-17.78"/>
</segment>
</net>
<net name="MOUSEPIN1" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART0_TX/I2C0_SDA/SPI0_RX/GP0"/>
<wire x1="106.68" y1="58.42" x2="91.44" y2="58.42" width="0.1524" layer="91"/>
<wire x1="91.44" y1="58.42" x2="91.44" y2="78.74" width="0.1524" layer="91"/>
<wire x1="91.44" y1="78.74" x2="109.22" y2="78.74" width="0.1524" layer="91"/>
<label x="109.22" y="78.74" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="MOUSEPIN0" class="0">
<segment>
<pinref part="U3" gate="A" pin="UART0_RX/I2C0_SCL/GPI0_CSN/GP1"/>
<wire x1="106.68" y1="55.88" x2="88.9" y2="55.88" width="0.1524" layer="91"/>
<wire x1="88.9" y1="55.88" x2="88.9" y2="81.28" width="0.1524" layer="91"/>
<wire x1="88.9" y1="81.28" x2="109.22" y2="81.28" width="0.1524" layer="91"/>
<label x="109.22" y="81.28" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="RIGHTSTICKX" class="0">
<segment>
<pinref part="U2" gate="A" pin="8"/>
<wire x1="7.62" y1="22.86" x2="-5.08" y2="22.86" width="0.1524" layer="91"/>
<label x="-10.16" y="22.86" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="LEFTSTICKX" class="0">
<segment>
<pinref part="U2" gate="A" pin="5"/>
<wire x1="7.62" y1="30.48" x2="-5.08" y2="30.48" width="0.1524" layer="91"/>
<label x="-10.16" y="30.48" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="CLOCK" class="0">
<segment>
<pinref part="U2" gate="A" pin="10"/>
<wire x1="53.34" y1="25.4" x2="66.04" y2="25.4" width="0.1524" layer="91"/>
<wire x1="66.04" y1="25.4" x2="66.04" y2="27.94" width="0.1524" layer="91"/>
<pinref part="U3" gate="A" pin="UART1_RX/I2C0_SCL/SPI0_CSN/GP5"/>
<wire x1="66.04" y1="27.94" x2="106.68" y2="43.18" width="0.1524" layer="91"/>
<label x="58.42" y="25.4" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="MOSI" class="0">
<segment>
<pinref part="U2" gate="A" pin="11"/>
<wire x1="53.34" y1="27.94" x2="63.5" y2="27.94" width="0.1524" layer="91"/>
<wire x1="63.5" y1="27.94" x2="63.5" y2="35.56" width="0.1524" layer="91"/>
<pinref part="U3" gate="A" pin="I2C1_SCL/SPI0_TX/GP3"/>
<wire x1="63.5" y1="35.56" x2="106.68" y2="48.26" width="0.1524" layer="91"/>
<label x="58.42" y="27.94" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="MISO" class="0">
<segment>
<pinref part="U2" gate="A" pin="12"/>
<wire x1="53.34" y1="30.48" x2="60.96" y2="30.48" width="0.1524" layer="91"/>
<pinref part="U3" gate="A" pin="UART1_TX/I2C0_SDA/SPI0_RX/GP4"/>
<wire x1="60.96" y1="30.48" x2="106.68" y2="45.72" width="0.1524" layer="91"/>
<label x="58.42" y="30.48" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
<net name="CHIPSELECT" class="0">
<segment>
<pinref part="U2" gate="A" pin="13"/>
<wire x1="53.34" y1="33.02" x2="60.96" y2="33.02" width="0.1524" layer="91"/>
<wire x1="60.96" y1="33.02" x2="60.96" y2="38.1" width="0.1524" layer="91"/>
<pinref part="U3" gate="A" pin="I2C1_SDA/SPI0_SCK/GP2"/>
<wire x1="60.96" y1="38.1" x2="106.68" y2="50.8" width="0.1524" layer="91"/>
<label x="58.42" y="40.64" size="1.016" layer="95" ratio="6"/>
</segment>
</net>
</nets>
</sheet>
</sheets>
</schematic>
</drawing>
<compatibility>
<note version="8.2" severity="warning">
Since Version 8.2, EAGLE supports online libraries. The ids
of those online libraries will not be understood (or retained)
with this version.
</note>
<note version="8.3" severity="warning">
Since Version 8.3, EAGLE supports URNs for individual library
assets (packages, symbols, and devices). The URNs of those assets
will not be understood (or retained) with this version.
</note>
<note version="8.3" severity="warning">
Since Version 8.3, EAGLE supports the association of 3D packages
with devices in libraries, schematics, and board files. Those 3D
packages will not be understood (or retained) with this version.
</note>
</compatibility>
</eagle>