import{_ as I}from"./preload-helper.101896b7.js";import{h as V,ap as x,aq as E,aH as P,ar as v,K as B,a as f,b as D,J as _,o as S,a4 as M,w as O,a9 as U,j as l,k as b,D as i,x as c,T as d,u as a,v as w,y as R,E as y,z as j,aI as q}from"./vue.bd0669ce.js";import{u as z}from"./keepAliveNames.f05bad75.js";import{u as H}from"./themeConfig.cb88f033.js";import{S as J}from"./storage.b628b270.js";import{e as K}from"./mitt.7f99bbc0.js";const F={class:"layout-parent"},G=V({name:"layoutParentView"}),se=V({...G,setup(Q){const g=x(()=>I(()=>import("./iframes.d821f897.js"),["assets/iframes.d821f897.js","assets/vue.bd0669ce.js"])),o=E(),A=P(),T=z(),k=H(),{keepAliveNames:n,cachedViews:p}=v(T),{themeConfig:m}=v(k),e=B({refreshRouterViewKey:"",iframeRefreshKey:"",keepAliveNameList:[],iframeList:[]}),u=f(()=>m.value.animation),L=f(()=>m.value.isTagsview?p.value:e.keepAliveNameList),h=f(()=>o.meta.isIframe),N=async()=>{A.getRoutes().forEach(s=>{s.meta.isIframe&&(s.meta.isIframeOpen=!1,s.meta.loading=!0,e.iframeList.push({...s}))})};return D(()=>{e.keepAliveNameList=n.value,K.on("onTagsViewRefreshRouterView",s=>{e.keepAliveNameList=n.value.filter(t=>o.name!==t),e.refreshRouterViewKey="",e.iframeRefreshKey="",_(()=>{e.refreshRouterViewKey=s,e.iframeRefreshKey=s,e.keepAliveNameList=n.value})})}),S(()=>{N(),_(()=>{setTimeout(()=>{if(m.value.isCacheTagsView){let s=J.get("tagsViewList")||[];p.value=s.filter(t=>{var r;return(r=t.meta)==null?void 0:r.isKeepAlive}).map(t=>t.name)}},0)})}),M(()=>{K.off("onTagsViewRefreshRouterView",()=>{})}),O(()=>o.fullPath,()=>{e.refreshRouterViewKey=decodeURI(o.fullPath)},{immediate:!0}),(s,t)=>{const r=U("router-view");return l(),b("div",F,[i(r,null,{default:c(({Component:C})=>[i(d,{name:a(u),mode:"out-in"},{default:c(()=>[(l(),w(q,{include:a(L)},[R((l(),w(j(C),{key:e.refreshRouterViewKey,class:"w100"})),[[y,!a(h)]])],1032,["include"]))]),_:2},1032,["name"])]),_:1}),i(d,{name:a(u),mode:"out-in"},{default:c(()=>[R(i(a(g),{class:"w100",refreshKey:e.iframeRefreshKey,name:a(u),list:e.iframeList},null,8,["refreshKey","name","list"]),[[y,a(h)]])]),_:1},8,["name"])])}}});export{se as default};