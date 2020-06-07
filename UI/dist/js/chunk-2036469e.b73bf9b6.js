(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2036469e"],{4562:function(e,t,i){"use strict";var o=i("8348"),r=i.n(o);r.a},8348:function(e,t,i){},d397:function(e,t,i){"use strict";i.r(t);var o=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"box"},[i("form",{staticClass:"program-form",staticStyle:{padding:"15px"},on:{submit:function(t){return t.preventDefault(),e.handleSubmit()}}},[i("h2",{staticClass:"form-heading"},[e._v("SINGLE VIDEO FORM")]),i("div",{staticClass:"form-row"},[i("div",{staticClass:"form-group col-md-6"},[i("label",[e._v("Program type")]),i("input",{directives:[{name:"model",rawName:"v-model",value:e.program.type,expression:"program.type"}],staticClass:"form-control ",attrs:{type:"text",required:"",readOnly:""},domProps:{value:e.program.type},on:{input:function(t){t.target.composing||e.$set(e.program,"type",t.target.value)}}})]),i("div",{staticClass:"form-group col-md-6"},[i("label",{attrs:{for:"inputPassword4"}},[e._v("Video name")]),i("input",{directives:[{name:"model",rawName:"v-model",value:e.singleVideo.videoTitle,expression:"singleVideo.videoTitle"}],staticClass:"form-control",attrs:{type:"text",required:""},domProps:{value:e.singleVideo.videoTitle},on:{input:function(t){t.target.composing||e.$set(e.singleVideo,"videoTitle",t.target.value)}}})])]),i("div",{staticClass:"form-group col-md-12"},[i("label",{attrs:{for:"inputAddress"}},[e._v("Description")]),i("input",{directives:[{name:"model",rawName:"v-model",value:e.singleVideo.description,expression:"singleVideo.description"}],staticClass:"form-control",attrs:{type:"text",required:""},domProps:{value:e.singleVideo.description},on:{input:function(t){t.target.composing||e.$set(e.singleVideo,"description",t.target.value)}}})]),i("div",{staticClass:"form-group col-md-12"},[i("label",{attrs:{for:"inputAddress"}},[e._v("Video Url")]),i("input",{directives:[{name:"model",rawName:"v-model",value:e.singleVideo.videoUrl,expression:"singleVideo.videoUrl"}],staticClass:"form-control",attrs:{type:"text",required:""},domProps:{value:e.singleVideo.videoUrl},on:{input:function(t){t.target.composing||e.$set(e.singleVideo,"videoUrl",t.target.value)}}})]),i("button",{staticClass:"btn btn-primary",attrs:{type:"submit"}},[e._v("Save video")])])])},r=[],s=(i("8e6e"),i("ac6a"),i("456d"),i("bd86")),n=i("2f62");function a(e,t){var i=Object.keys(e);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);t&&(o=o.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),i.push.apply(i,o)}return i}function l(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{};t%2?a(i,!0).forEach(function(t){Object(s["a"])(e,t,i[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(i)):a(i).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(i,t))})}return e}var d={name:"SingleVideoForm",data:function(){return{singleVideo:{program:{id:""},videoTitle:"",videoUrl:null,description:"",videoImgUrls:null,crewList:null}}},computed:l({},Object(n["c"])(["program"])),methods:l({},Object(n["b"])(["addSingleVideo","imageUpload"]),{handleSubmit:function(){var e=this;this.singleVideo.program.id=this.program.id,this.addSingleVideo(this.singleVideo).then(function(t){t?(e.$swal("","Successfully added","success"),e.$router.push("/singleVideo")):console.log("Something wrong")}).catch(function(e){console.log(e)})}})},c=d,u=(i("4562"),i("2877")),p=Object(u["a"])(c,o,r,!1,null,null,null);t["default"]=p.exports}}]);
//# sourceMappingURL=chunk-2036469e.b73bf9b6.js.map