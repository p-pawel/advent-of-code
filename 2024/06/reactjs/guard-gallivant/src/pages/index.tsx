import React, {useState} from "react";
import {BoardRendererService} from "@/services/board-renderer.service";
import {GameStateService} from "@/services/game-state.service";
// import {inputString} from "../data/doNotCommit";
import {inputString} from "../data/exampleString";

// import {Part2BruteForceService} from "@/services/part2-brute-force.service";
// const bruteForceService = new Part2BruteForceService(inputString);
// bruteForceService.main();

const gameStateService = new GameStateService(inputString)
const boardRenderService = new BoardRendererService(' ');



// gameStateService.setAdditionalObstacle(54, 54);
// gameStateService.setAdditionalObstacle(26, 77);

export default function Home() {

  const [boardView, setBoardView] = useState<string>(boardRenderService.renderBoardView(gameStateService.board, gameStateService.player, gameStateService.history, gameStateService.additionalObstacle));
  const [canMove, setCanMove] = useState<boolean>(true);
  const [ownSteps, setOwnSteps] = useState<boolean>(false);
  const [visits, setVisits] = useState<number>(1);
  const [possibleLoops, setPossibleLoops] = useState<number>(0);
  const [auto, setAuto] = useState<boolean>(false);

  function move() {
    gameStateService.move();  
    setBoardView(boardRenderService.renderBoardView(gameStateService.board, gameStateService.player, gameStateService.history, gameStateService.additionalObstacle));
    setCanMove(gameStateService.isPlayerWithinBoard());
    setOwnSteps(gameStateService.isPlayerFollowingOwnSteps());
    setVisits(gameStateService.countVisits());
    setPossibleLoops(gameStateService.possibleLoopPlaces.size);

    if (auto && gameStateService.isPlayerWithinBoard()) {
      setTimeout(() => move(), 100); // perhaps this should become an effect to allow to stop the loop again
    }
  }

  return (
    <div
      className={`grid grid-rows-[20px_1fr_20px] items-center justify-items-center min-h-screen p-8 pb-20 gap-16 sm:p-20 font-[family-name:var(--font-geist-sans)]`}
    >
      <main className="flex flex-col gap-8 row-start-2 items-center sm:items-start">
        <pre>{ boardView }</pre>
      </main>
      <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        <div>
        <button
            disabled={!canMove || ownSteps}
            onClick={() => move()}    
            className="bg-blue-500 disabled:bg-gray-600 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
          { canMove ? (ownSteps ? 'Guard is looped' : 'Move') : 'Guard left a board'}
        </button>
          <div>
            <label>
              <input
                  type="checkbox"
                  checked={auto}
                  onChange={() => setAuto(!auto)}
              />
              auto
            </label>
          </div>
        </div>
        <div>
          Visits: {visits}
          <br/>
          Possible loop places: {possibleLoops}
        </div>
      </footer>
    </div>
  );
}
