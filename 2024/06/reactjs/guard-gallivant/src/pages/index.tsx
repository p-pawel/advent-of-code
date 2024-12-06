import localFont from "next/font/local";
import React, {useState} from "react";
import {Player} from "@/model/player";
import {BoardRendererService} from "@/services/board-renderer.service";
import {Board} from "@/model/board";

const geistSans = localFont({
  src: "./fonts/GeistVF.woff",
  variable: "--font-geist-sans",
  weight: "100 900",
});
const geistMono = localFont({
  src: "./fonts/GeistMonoVF.woff",
  variable: "--font-geist-mono",
  weight: "100 900",
});

const boardRenderService = new BoardRendererService(' ');


export default function Home() {

  const inputString = 
      "....#.....\n" +
      ".........#\n" +
      "..........\n" +
      "..#.......\n" +
      ".......#..\n" +
      "..........\n" +
      ".#..^.....\n" +
      "........#.\n" +
      "#.........\n" +
      "......#...";

  const [board, setInnerField] = useState<Board>(new Board(inputString)); // Example field that will be rendered

  const [player, setPlayer] = useState<Player>(Player.fromTheInputBoard(inputString));
  const [boardView, setBoardView] = useState<string>(boardRenderService.renderBoardView(board, player));
  
  
  return (
    <div
      className={`${geistSans.variable} ${geistMono.variable} grid grid-rows-[20px_1fr_20px] items-center justify-items-center min-h-screen p-8 pb-20 gap-16 sm:p-20 font-[family-name:var(--font-geist-sans)]`}
    >
      <main className="flex flex-col gap-8 row-start-2 items-center sm:items-start">
        <pre>{ boardView }</pre>
      </main>
      <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
          Move
        </button>
      </footer>
    </div>
  );
}
