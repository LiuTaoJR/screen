(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-dd4391f0"],{"24cb":function(t,e,a){"use strict";a("709c")},"28a5":function(t,e,a){"use strict";var i=a("aae3"),s=a("cb7c"),n=a("ebd6"),o=a("0390"),r=a("9def"),c=a("5f1b"),l=a("520a"),u=a("79e5"),d=Math.min,h=[].push,f="split",p="length",v="lastIndex",m=4294967295,g=!u((function(){RegExp(m,"y")}));a("214f")("split",2,(function(t,e,a,u){var x;return x="c"=="abbc"[f](/(b)*/)[1]||4!="test"[f](/(?:)/,-1)[p]||2!="ab"[f](/(?:ab)*/)[p]||4!="."[f](/(.?)(.?)/)[p]||"."[f](/()()/)[p]>1||""[f](/.?/)[p]?function(t,e){var s=String(this);if(void 0===t&&0===e)return[];if(!i(t))return a.call(s,t,e);var n,o,r,c=[],u=(t.ignoreCase?"i":"")+(t.multiline?"m":"")+(t.unicode?"u":"")+(t.sticky?"y":""),d=0,f=void 0===e?m:e>>>0,g=new RegExp(t.source,u+"g");while(n=l.call(g,s)){if(o=g[v],o>d&&(c.push(s.slice(d,n.index)),n[p]>1&&n.index<s[p]&&h.apply(c,n.slice(1)),r=n[0][p],d=o,c[p]>=f))break;g[v]===n.index&&g[v]++}return d===s[p]?!r&&g.test("")||c.push(""):c.push(s.slice(d)),c[p]>f?c.slice(0,f):c}:"0"[f](void 0,0)[p]?function(t,e){return void 0===t&&0===e?[]:a.call(this,t,e)}:a,[function(a,i){var s=t(this),n=void 0==a?void 0:a[e];return void 0!==n?n.call(a,s,i):x.call(String(s),a,i)},function(t,e){var i=u(x,t,this,e,x!==a);if(i.done)return i.value;var l=s(t),h=String(this),f=n(l,RegExp),p=l.unicode,v=(l.ignoreCase?"i":"")+(l.multiline?"m":"")+(l.unicode?"u":"")+(g?"y":"g"),y=new f(g?l:"^(?:"+l.source+")",v),b=void 0===e?m:e>>>0;if(0===b)return[];if(0===h.length)return null===c(y,h)?[h]:[];var w=0,C=0,D=[];while(C<h.length){y.lastIndex=g?C:0;var _,k=c(y,g?h:h.slice(C));if(null===k||(_=d(r(y.lastIndex+(g?0:C)),h.length))===w)C=o(h,C,p);else{if(D.push(h.slice(w,C)),D.length===b)return D;for(var S=1;S<=k.length-1;S++)if(D.push(k[S]),D.length===b)return D;C=w=_}}return D.push(h.slice(w)),D}]}))},"2d56":function(t,e,a){},"3b2b":function(t,e,a){var i=a("7726"),s=a("5dbc"),n=a("86cc").f,o=a("9093").f,r=a("aae3"),c=a("0bfb"),l=i.RegExp,u=l,d=l.prototype,h=/a/g,f=/a/g,p=new l(h)!==h;if(a("9e1e")&&(!p||a("79e5")((function(){return f[a("2b4c")("match")]=!1,l(h)!=h||l(f)==f||"/a/i"!=l(h,"i")})))){l=function(t,e){var a=this instanceof l,i=r(t),n=void 0===e;return!a&&i&&t.constructor===l&&n?t:s(p?new u(i&&!n?t.source:t,e):u((i=t instanceof l)?t.source:t,i&&n?c.call(t):e),a?this:d,l)};for(var v=function(t){t in l||n(l,t,{configurable:!0,get:function(){return u[t]},set:function(e){u[t]=e}})},m=o(u),g=0;m.length>g;)v(m[g++]);d.constructor=l,l.prototype=d,a("2aba")(i,"RegExp",l)}a("7a56")("RegExp")},"505e":function(t,e,a){},"5f78":function(t,e,a){"use strict";a("a9f1")},"6bd8":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t._self._c;return e("div",{attrs:{id:"data-view"}},[e("dv-full-screen-container",[e("dv-border-box-1",{staticClass:"main-container"},[e("div",{staticClass:"right-main-container"},[e("div",{staticClass:"rmc-top-container"},[e("dv-border-box-3",{staticClass:"rmctc-left-container"},[t.sonRefresh?e("Center-Cmp",{attrs:{topData:t.topData}}):t._e()],1)],1),e("dv-border-box-4",{staticClass:"rmc-bottom-container"},[t.sonRefresh?e("Bottom-Charts",{attrs:{bottomData:t.bottomData}}):t._e()],1)],1)])],1)],1)},s=[],n=(a("3b2b"),a("a481"),a("96cf"),a("1da1")),o=(a("7f7f"),function(){var t=this,e=t._self._c;return t.isShow?e("div",{staticClass:"left-chart-1"},[e("div",{staticClass:"lc1-header"},[t._v("当日工艺情况汇总")]),e("div",[e("div",{staticClass:"water-top"},[t.showWater?e("dv-water-level-pond",{staticStyle:{margin:"0 auto"},attrs:{config:t.water1}}):t._e()],1)]),e("div",{staticStyle:{width:"150px",margin:"10px auto 0px","text-align":"center"}},[t._v("\n    印刷期望值("+t._s(t.hopeShua)+")\n  ")]),e("dv-decoration-2",{staticStyle:{height:"15px","margin-top":"15px",display:"block"}}),e("div",{staticClass:"new-bottom"},t._l(t.newBottomList,(function(a,i){return e("div",{key:i,staticClass:"bottom-div"},[e("p",{staticClass:"first-p"},[t._v(t._s(a.name))]),e("div",{staticClass:"bottom-item"},[e("div",{style:"width:"+a.percent+"%;background-color:"+a.color},[e("p",[t._v(t._s(a.percent)+"%")])])]),e("p",{staticClass:"second-p"},[t._v(t._s(a.planValue))])])})),0),e("div",{staticClass:"left-bottom1"})],1):t._e()}),r=[],c=(a("ac6a"),{name:"LeftChart1",props:{leftData:{type:Array,default:[]}},data:function(){return{water1:{showWater:!1,data:[0],shape:"round",waveHeight:25,waveNum:2},water2:{data:[66,45],shape:"round"},config:{data:[],showValue:!0},isShow:!1,hopeShua:0,customColor:["#f56c6c","#e6a23c","#5cb87a","#1989fa","#6f7ad3","#f56c6c","#e6a23c","#5cb87a","#1989fa","#6f7ad3","#f56c6c","#e6a23c","#5cb87a"],progressList:[],newBottomList:[]}},mounted:function(){this.updateData()},watch:{leftData:{handler:function(t,e){t&&this.updateData()},deep:!0}},methods:{updateData:function(){var t=this,e=[],a=0,i=0;this.leftData.forEach((function(s,n){if("印刷"==s.serviceName)a=s.planQuantity,t.hopeShua=a,i=s.actualQuantity;else{var o=s.actualQuantity/s.planQuantity*100;o=o.toFixed(2);var r={name:null,value:null,color:"",planValue:null,percent:null};r.name=s.serviceName,r.value=s.actualQuantity,r.color=t.customColor[n],r.planValue=s.planQuantity,r.percent=o,e.push(r)}}));var s=i/a*100;s=parseInt(s),0!=a&&(this.water1.data=[],this.water1.data.push(s)),this.showWater=!1,this.showWater=!0,this.config.data=e,this.newBottomList=e,this.progressList=this.leftData,this.isShow=!0},setItemProgress:function(t){return t.actualQuantity>t.planQuantity?100:parseInt(100*(t.actualQuantity/t.planQuantity).toFixed(1))},setItemText:function(t){return function(){return+t.actualQuantity+" / "+t.planQuantity}},setColor:function(t){return this.customColor[t]}}}),l=c,u=(a("fb73"),a("2877")),d=Object(u["a"])(l,o,r,!1,null,null,null),h=d.exports,f=function(){var t=this,e=t._self._c;return t.isShow?e("div",{staticClass:"center-cmp"},[e("div",{staticClass:"cc-header"},[e("dv-decoration-1",{staticStyle:{width:"200px",height:"50px"}}),t._m(0),e("div",{staticStyle:{"margin-top":"20px"}},[t._v("海德堡HDU大屏演示")]),e("dv-decoration-1",{staticStyle:{width:"200px",height:"50px"}})],1),e("div",{staticClass:"show-time",staticStyle:{color:"rgb(0, 192, 255, 0.5)"}},[t._v("\n    "+t._s(t.times)+"\n  ")]),e("div",{staticClass:"cc-details"},[e("div",[t._v("订单总数")]),t._l(t.arrNum,(function(a,i){return e("div",{key:i,staticClass:"card"},[t._v("\n      "+t._s(a)+"\n    ")])}))],2),e("div",{staticClass:"cc-main-container"},[e("div",{staticClass:"main-content-left"},[e("div",{staticClass:"dc-text",staticStyle:{"margin-top":"20px"}},[e("div",{staticStyle:{"margin-top":"-140px"}},[t._v("\n          印张数\n          "),e("dv-decoration-3",{staticStyle:{width:"70px",height:"20px"}})],1),e("div",[t._v("\n          换版数\n          "),e("dv-decoration-3",{staticStyle:{width:"70px",height:"20px"}})],1)]),e("div",{staticClass:"left-dock",attrs:{id:"refreshDiv"}},[e("div",{staticClass:"dock-div"},[e("dv-charts",{staticClass:"chart-putall",attrs:{option:t.option4}})],1),e("div",{staticClass:"dock-div"},[e("dv-charts",{staticClass:"chart-putall",attrs:{option:t.option5}})],1)])]),e("div",{staticClass:"main-content-right"},[e("div",{staticClass:"chart-name"},[t._v("\n        印张量月趋势\n        "),e("dv-decoration-3",{staticStyle:{width:"200px",height:"20px"}})],1),e("dv-charts",{attrs:{option:t.option}})],1)])]):t._e()},p=[function(){var t=this,e=t._self._c;return e("div",{staticClass:"midia-time"},[e("div",{staticStyle:{width:"200px","margin-left":"10px",color:"rgb(0, 192, 255, 0.5)"}},[t._v("\n        Present by\n      ")]),e("div",{staticStyle:{width:"250px","margin-left":"10px",color:"rgb(0, 192, 255, 0.5)"}},[t._v("\n        海德堡印刷设备(北京)有限公司\n      ")])])}],v=(a("6b54"),a("28a5"),{name:"CenterCmp",props:{topData:{type:Object,default:null}},data:function(){return{option4:{},option4Copy:{xAxis:{data:"value",min:0,axisLabel:{formatter:function(t){var e=t.value;return 100*Math.round(e/100)},style:{fill:"#999"}},axisLine:{style:{stroke:"#999"}},axisTick:{show:!1}},yAxis:{splitLine:{show:!1},data:[],axisLabel:{style:{fill:"#999"}},axisLine:{style:{stroke:"#999"}}},series:[{data:[],type:"bar",gradient:{color:["#37a2da","#67e0e3"]},animationCurve:"easeOutBack"}]},option5:{},option5Copy:{xAxis:{data:"value",min:0,axisLabel:{formatter:function(t){var e=t.value;return 10*Math.round(e/10)},style:{fill:"#999"}},axisLine:{style:{stroke:"#999"}},axisTick:{show:!1}},yAxis:{splitLine:{show:!1},data:[],axisLabel:{style:{fill:"#999"}},axisLine:{style:{stroke:"#999"}}},series:[{data:[],type:"bar",animationCurve:"easeOutBack",gradient:{color:["#37a2da","#67e0e3"]}}]},option:{legend:{textStyle:{fill:"#fff"}},xAxis:{data:[],axisLine:{style:{stroke:"#999"}},axisLabel:{style:{fill:"#999"}},axisTick:{show:!1}},yAxis:{data:"value",splitLine:{show:!1},axisLine:{style:{stroke:"#999"}},axisLabel:{style:{fill:"#999"},formatter:function(t){var e=t.value;return 100*Math.round(e/100)}},axisTick:{show:!1},min:5e6,max:4e7},series:[{data:[],type:"line",name:"设备完好率",lineArea:{show:!0,gradient:["rgba(55, 162, 218, 0.6)","rgba(55, 162, 218, 0)"]},linePoint:{show:!0,radius:4,style:{fill:"#00db95"}}}]},times:"",timer:null,isShow:!1,orderNumIn:0,orderNumOut:0,orderAll:0,workNumIn:0,workNumOut:0,workAll:0,arrNum:[]}},created:function(){this.updateTime()},watch:{topData:{handler:function(t,e){t&&this.updateData()},deep:!0}},mounted:function(){this.updateData()},beforeDestroy:function(){this.timer&&clearTimeout(this.timer)},methods:{updateData:function(){var t=this;this.option.xAxis.data=[],this.option.series[0].data=[],this.option4={},this.option5={},this.option4=JSON.parse(JSON.stringify(this.option4Copy)),this.option5=JSON.parse(JSON.stringify(this.option5Copy)),this.arrNum=this.topData.orderNum.toString().split("");var e=this.topData.printNumMonth,a=[];e.length<=1?this.option.xAxis.boundaryGap=!0:this.option.xAxis.boundaryGap=!1,e.length,this.option.series[0].smooth=!1,e.forEach((function(e){t.option.xAxis.data.push(e.month),t.option.series[0].data.push(e.num),a.push(e.num)}));var i=this.topData.printNum,s=this.topData.changeNum,n=[],o=[];i.forEach((function(e){t.option4.yAxis.data.push(e.machineName),t.option4.series[0].data.push(e.num),n.push(e.num)})),this.option4.xAxis.max=Math.max.apply(null,n),s.forEach((function(e){t.option5.yAxis.data.push(e.machineName),t.option5.series[0].data.push(e.num),o.push(e.num)})),this.option5.xAxis.max=Math.max.apply(null,o),this.isShow=!0},getTime:function(){var t=new Date,e=function(t){if(!t)return"";var e=new Date(t),a=e.getFullYear()+"-",i=(e.getMonth()+1<10?"0"+(e.getMonth()+1):e.getMonth()+1)+"-",s=e.getDate()>9?e.getDate()+" ":"0"+e.getDate()+" ",n=e.getHours()>9?e.getHours()+":":"0"+e.getHours()+":",o=e.getMinutes()>9?e.getMinutes()+":":"0"+e.getMinutes()+":",r=e.getSeconds()>9?e.getSeconds():"0"+e.getSeconds();return a+i+s+n+o+r};this.times=e(t)},updateTime:function(){var t=this;this.getTime(),this.timer=setTimeout((function(){t.updateTime()}),1e3)}}}),m=v,g=(a("24cb"),Object(u["a"])(m,f,p,!1,null,"cbff874a",null)),x=g.exports,y=function(){var t=this,e=t._self._c;return t.isShow?e("div",{staticClass:"all-charts"},[e("div",{staticClass:"top-charts"},[t._v("当日设备印刷速度情况")]),e("div",{staticClass:"bottom-charts"},[e("div",{staticClass:"bc-chart-item"},[e("dv-charts",{attrs:{option:t.config1}}),e("div",{staticClass:"bcci-header-sec"},[t._v("\n                "+t._s(t.config1.series[0].data[0].value)+"张/小时\n            ")])],1),e("div",{staticClass:"bc-chart-item"},[e("dv-charts",{attrs:{option:t.config2}}),e("div",{staticClass:"bcci-header-sec"},[t._v("\n                "+t._s(t.config2.series[0].data[0].value)+"张/小时\n            ")])],1),e("div",{staticClass:"bc-chart-item"},[e("dv-charts",{attrs:{option:t.config3}}),e("div",{staticClass:"bcci-header-sec"},[t._v("\n                "+t._s(t.config3.series[0].data[0].value)+"张/小时\n            ")])],1),e("div",{staticClass:"bc-chart-item"},[e("dv-charts",{attrs:{option:t.config4}}),e("div",{staticClass:"bcci-header-sec"},[t._v("\n                "+t._s(t.config4.series[0].data[0].value)+"张/小时\n            ")])],1)])]):t._e()},b=[],w={name:"BottomCharts",props:{bottomData:{type:Array,default:[]}},data:function(){return{config1:{title:{text:"CD 102-5+L",style:{fill:"#fff"}},series:[{min:0,max:15e3,type:"gauge",data:[{value:0}],center:["50%","55%"],axisLabel:{style:{fill:"#fff"}},axisTick:{style:{stroke:"#fff"}},animationCurve:"easeInOutBack"}]},config2:{title:{text:"CD 102-8+L",style:{fill:"#fff"}},series:[{min:0,max:15e3,type:"gauge",data:[{value:0}],center:["50%","55%"],axisLabel:{style:{fill:"#fff"}},axisTick:{style:{stroke:"#fff"}},animationCurve:"easeInOutBack"}]},config3:{title:{text:"CX 104-7+L",style:{fill:"#fff"}},series:[{min:0,max:15e3,type:"gauge",data:[{value:0}],center:["50%","55%"],axisLabel:{style:{fill:"#fff"}},axisTick:{style:{stroke:"#fff"}},animationCurve:"easeInOutBack"}]},config4:{title:{text:"XL 162-4",style:{fill:"#fff"}},series:[{min:0,max:15e3,type:"gauge",data:[{value:0}],center:["50%","55%"],axisLabel:{style:{fill:"#fff"}},axisTick:{style:{stroke:"#fff"}},animationCurve:"easeInOutBack"}]},config5:{title:{text:"XL 162-4",style:{fill:"#fff"}},series:[{min:0,max:15e3,type:"gauge",data:[{value:12e3}],center:["50%","55%"],axisLabel:{style:{fill:"#fff"}},axisTick:{style:{stroke:"#fff"}},animationCurve:"easeInOutBack"}]},isShow:!1}},mounted:function(){this.updateData()},watch:{bottomData:{handler:function(t,e){t&&this.updateData()},deep:!0}},methods:{updateData:function(){this.config1.series[0].data[0].value=this.bottomData[0].speed,this.config2.series[0].data[0].value=this.bottomData[1].speed,this.config3.series[0].data[0].value=this.bottomData[2].speed,this.config4.series[0].data[0].value=this.bottomData[3].speed,this.isShow=!0}}},C=w,D=(a("5f78"),Object(u["a"])(C,y,b,!1,null,null,null)),_=D.exports,k={name:"DataView",components:{LeftChart1:h,CenterCmp:x,BottomCharts:_},data:function(){return{allData:null,sonRefresh:!1,leftData:[],topData:null,bottomData:[]}},mounted:function(){var t=Object(n["a"])(regeneratorRuntime.mark((function t(){var e,a=this;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return window.location.href,window.location.port,console.log("浏览器宽度:"+window.screen.width*window.devicePixelRatio),console.log("浏览器高度:"+window.screen.height*window.devicePixelRatio),t.next=6,this.getData();case 6:return t.next=8,this.refreshFlag();case 8:clearInterval(e),e=setInterval((function(){a.getData(),a.refreshFlag()}),6e4);case 10:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),methods:{getData:function(){var t=Object(n["a"])(regeneratorRuntime.mark((function t(){var e,a,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e=this.formatDate(new Date,"yyyy-MM-dd"),t.next=3,this.axios.get("http://192.168.101.254:10001/screen/getScreenData?date=".concat(e));case 3:a=t.sent,i=a.data,this.allData=null,this.allData=i.data,this.topData=this.allData,this.bottomData=this.allData.machineSpeed;case 9:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),refreshFlag:function(){this.sonRefresh=!1,this.sonRefresh=!0},formatDate:function(t,e){if(/(y+)/.test(e)){var a=t.getFullYear()+"";e=e.replace(RegExp.$1,a.substr(4-RegExp.$1.length))}var i={"M+":t.getMonth()+1,"d+":t.getDate(),"h+":t.getHours(),"m+":t.getMinutes(),"s+":t.getSeconds()};for(var s in i)if(new RegExp("(".concat(s,")")).test(e)){var n=i[s]+"";e=e.replace(RegExp.$1,1==RegExp.$1.length?n:this.padLeftZero(n))}return e},padLeftZero:function(t){return("00"+t).substr(t.length)}}},S=k,L=(a("c4bd"),Object(u["a"])(S,i,s,!1,null,"d3a5ea42",null));e["default"]=L.exports},"709c":function(t,e,a){},a9f1:function(t,e,a){},aae3:function(t,e,a){var i=a("d3f4"),s=a("2d95"),n=a("2b4c")("match");t.exports=function(t){var e;return i(t)&&(void 0!==(e=t[n])?!!e:"RegExp"==s(t))}},c4bd:function(t,e,a){"use strict";a("2d56")},fb73:function(t,e,a){"use strict";a("505e")}}]);
//# sourceMappingURL=chunk-dd4391f0.89a81b01.js.map