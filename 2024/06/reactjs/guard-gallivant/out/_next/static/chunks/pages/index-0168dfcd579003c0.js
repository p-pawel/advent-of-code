(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[332],{2022:(t,e,r)=>{(window.__NEXT_P=window.__NEXT_P||[]).push(["/",function(){return r(1550)}])},1550:(t,e,r)=>{"use strict";r.r(e),r.d(e,{default:()=>u});var s=r(4848),i=r(6540);class a{renderBoardView(t,e,r,s){let i=t.content.split("\n").map(t=>t.split(""));r.filter(e=>e.x>=0&&e.y>=0&&e.x<t.width&&e.y<t.height).forEach(t=>i[t.y][t.x]=t.d),s&&(i[s.y][s.x]="O");let a="";a+=this.borderCharacter;for(let r=0;r<t.width;r++)a+=r==e.x&&-1==e.y?e.d:this.borderCharacter;a+=this.borderCharacter,a+="\n";for(let r=0;r<t.height;r++){a+=-1==e.x&&r==e.y?e.d:this.borderCharacter;for(let s=0;s<t.width;s++)a+=s==e.x&&r==e.y?e.d:i[r][s];a+=t.width==e.x&&r==e.y?e.d:this.borderCharacter,a+="\n"}a+=this.borderCharacter;for(let r=0;r<t.width;r++)a+=r==e.x&&t.height==e.y?e.d:this.borderCharacter;return a+this.borderCharacter}constructor(t=" "){this.borderCharacter=t}}class h{isObstacle(t,e){return!(t<0)&&!(e<0)&&!(t>=this.width)&&!(e>=this.height)&&this.inputString.split("\n")[e].charAt(t)==this.OBSTACLE_CHARACTER}constructor(t){this.inputString=t,this.OBSTACLE_CHARACTER="#",this.width=this.inputString.split("\n")[0].length,this.height=this.inputString.split("\n").length,this.content=t.replace(/[<>^v]/g,".")}}class o{static fromTheInputBoard(t){let e=t.split("\n");for(let t=0;t<e.length;t++){let r=e[t];for(let e=0;e<r.length;e++)if(["^",">","v","<"].includes(r[e]))return new o(e,t,r[e])}throw Error("Player not found in the input string")}forward(){let[t,e]=this.calcMove(this.d);return new o(this.x+t,this.y+e,this.d)}backward(){let[t,e]=this.calcMove(this.d);return new o(this.x-t,this.y-e,this.d)}turnRight(){return new o(this.x,this.y,this.calcRotate(this.d))}calcRotate(t){switch(t){case"^":return">";case">":return"v";case"v":return"<";case"<":return"^"}}calcMove(t){switch(t){case"^":return[0,-1];case">":return[1,0];case"v":return[0,1];case"<":return[-1,0]}}constructor(t,e,r){this.x=t,this.y=e,this.d=r}}class n{constructor(t,e){26==t&&27==e&&console.error("26,77"),this.x=t,this.y=e}}class l{get board(){return this._board}get player(){return this._player}get history(){return this._history}get possibleLoopPlaces(){return this._possibleLoopPlaces}get additionalObstacle(){return this._additionalObstacle}move(){let t=this.player.forward();this.isOutsideBoard(t,1)||(this.isObstacleThere(t.x,t.y)?this.updatePlayer(this.player.turnRight()):(this.testForLoop(this.player),this.updatePlayer(t)))}isObstacleThere(t,e){return!!this._additionalObstacle&&this._additionalObstacle.x==t&&this._additionalObstacle.y==e||this.board.isObstacle(t,e)}isOutsideBoard(t,e){return t.x<-e||t.y<-e||t.x>=this.board.width+e||t.y>=this.board.height+e}isPlayerWithinBoard(){return!this.isOutsideBoard(this.player,0)}countVisits(){return new Set(this._history.filter(t=>t.x>0&&t.y>0&&t.x<this.board.width&&t.y<this.board.height).map(t=>t.x+","+t.y)).size}testForLoop(t){if(history.length<=1)return;let e=t.forward(),r=new n(e.x,e.y),s=t.turnRight();if(this.wouldThatLeadToExactPreviousPosition(s,!1,r)){let t=new n(e.x,e.y);this.isThatPointInHistory(t,this.history)||this._possibleLoopPlaces.add(t)}}updatePlayer(t){this._player=t,this._history.push(t)}wasHereBefore(t,e){return e.filter(e=>e.x==t.x&&e.y==t.y&&e.d==t.d).length>0}isThatPointInHistory(t,e){return e.filter(e=>e.x==t.x&&e.y==t.y).length>0}wouldThatLeadToExactPreviousPosition(t,e,r){let s=[];s=s.concat(this.history);let i=t;for(;;){if(this.board.isObstacle(i.x,i.y)||r.x==i.x&&r.y==i.y){i=i.backward().turnRight();continue}if(this.isOutsideBoard(i,0))return!1;if(this.wasHereBefore(i,s))return!0;s.push(i),i=i.forward()}}setAdditionalObstacle(t,e){this._additionalObstacle=new n(t,e)}isPlayerFollowingOwnSteps(){return this.wasHereBefore(this.player.forward(),this._history)}constructor(t){this.inputString=t,this._history=[],this._possibleLoopPlaces=new Set,this._board=new h(t),this._history=[],this.updatePlayer(o.fromTheInputBoard(t))}}let d=new l("....#.....\n.........#\n..........\n..#.......\n.......#..\n..........\n.#..^.....\n........#.\n#.........\n......#..."),c=new a(" ");function u(){let[t,e]=(0,i.useState)(c.renderBoardView(d.board,d.player,d.history,d.additionalObstacle)),[r,a]=(0,i.useState)(!0),[h,o]=(0,i.useState)(!1),[n,l]=(0,i.useState)(1),[u,y]=(0,i.useState)(0),[p,b]=(0,i.useState)(!1);return(0,s.jsxs)("div",{className:"grid grid-rows-[20px_1fr_20px] items-center justify-items-center min-h-screen p-8 pb-20 gap-16 sm:p-20 font-[family-name:var(--font-geist-sans)]",children:[(0,s.jsx)("main",{className:"flex flex-col gap-8 row-start-2 items-center sm:items-start",children:(0,s.jsx)("pre",{children:t})}),(0,s.jsxs)("footer",{className:"row-start-3 flex gap-6 flex-wrap items-center justify-center",children:[(0,s.jsxs)("div",{children:[(0,s.jsx)("button",{disabled:!r||h,onClick:()=>(function t(){d.move(),e(c.renderBoardView(d.board,d.player,d.history,d.additionalObstacle)),a(d.isPlayerWithinBoard()),o(d.isPlayerFollowingOwnSteps()),l(d.countVisits()),y(d.possibleLoopPlaces.size),p&&d.isPlayerWithinBoard()&&setTimeout(()=>t(),100)})(),className:"bg-blue-500 disabled:bg-gray-600 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded",children:r?h?"Guard is looped":"Move":"Guard left a board"}),(0,s.jsx)("div",{children:(0,s.jsxs)("label",{children:[(0,s.jsx)("input",{type:"checkbox",checked:p,onChange:()=>b(!p)}),"auto"]})})]}),(0,s.jsxs)("div",{children:["Visits: ",n,(0,s.jsx)("br",{}),"Possible loop places: ",u]})]})]})}}},t=>{var e=e=>t(t.s=e);t.O(0,[636,593,792],()=>e(2022)),_N_E=t.O()}]);