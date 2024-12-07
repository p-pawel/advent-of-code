import {GameStateService} from "@/services/game-state.service";
import {Point} from "@/model/point";

export class Part2BruteForceService {
    private gameState: GameStateService;

    constructor(private inputString: string) {
        this.gameState = new GameStateService(this.inputString);
    }

    public main() {
        let loopableObstacles: Point[] = [];
             
        const initialPlayer = this.gameState.player;

        let width = this.gameState.board.width;
        let height = this.gameState.board.height;
        
        for (let x = 0; x < width; x++) {
            for (let y = 0; y < height; y++) {

                console.log("BruteForce", x, y);
                if (this.gameState.board.isObstacle(x, y)) {
                    console.log("skip - already an obstacle");
                    continue;
                }
                if (initialPlayer.x == x && initialPlayer.y == 7) {
                    console.log("skip - initial guard location");
                    continue;
                }
                this.gameState = new GameStateService(this.inputString);
                this.gameState.setAdditionalObstacle(x, y);
                if (this.isGameLoopable()) {
                    loopableObstacles.push(new Point(x, y));
                    console.log("loopableObstacles++");
                }
            }
        }
        console.log("loopableObstacles", JSON.stringify(loopableObstacles));
        console.log("loopableObstacles.length", loopableObstacles.length);


    }

    private isGameLoopable() {
        for (; ;) {
            this.gameState.move();

            if (!this.gameState.isPlayerWithinBoard()) {
                console.log("isGameLoopable -> false");
                return false;
            }
            if (this.gameState.isPlayerFollowingOwnSteps()) {
                console.log("isGameLoopable -> true");
                return true;
            }
            
        }
    }
}