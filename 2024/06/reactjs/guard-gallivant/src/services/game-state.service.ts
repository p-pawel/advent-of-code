import {Board} from "@/model/board";
import {Player} from "@/model/player";
import {Point} from "@/model/point";

export class GameStateService {

    private _board: Board;
    private _player!: Player;
    private _history: Player[] = [];
    private _possibleLoopPlaces = new Set<Point>();
    private _additionalObstacle?: Point;

    constructor(
        private inputString: string
    ) {
        this._board = new Board(inputString);
        this._history = [];
        this.updatePlayer(Player.fromTheInputBoard(inputString));
    }

    get board(): Board {
        return this._board;
    }

    get player(): Player {
        return this._player;
    }

    get history(): Player[] {
        return this._history;
    }
    
    get possibleLoopPlaces(): Set<Point> {
        return this._possibleLoopPlaces;
    }
    
    get additionalObstacle(): Point | undefined {
        return this._additionalObstacle;
    }
    
    public move() {
        const newPlayer = this.player.forward();
        if (this.isOutsideBoard(newPlayer, 1)) {
            return
        }

        if (this.isObstacleThere(newPlayer.x, newPlayer.y)) {
            this.updatePlayer(this.player.turnRight());
        } else {
            this.testForLoop(this.player);
            this.updatePlayer(newPlayer);
        }
    }

    private isObstacleThere(x: number, y: number) {
        if (this._additionalObstacle && this._additionalObstacle.x == x && this._additionalObstacle.y == y) {
            return true;
        }
        return this.board.isObstacle(x, y);
    }

    private isOutsideBoard(newPlayer: Player, margin: number) {
        return newPlayer.x < -margin || newPlayer.y < -margin || newPlayer.x >= this.board.width + margin || newPlayer.y >= this.board.height + margin;
    }

    isPlayerWithinBoard() {
        return !this.isOutsideBoard(this.player, 0);
    }

    public countVisits(): number {
        return new Set(
            this._history
                .filter(player => player.x > 0 && player.y > 0 && player.x < this.board.width && player.y < this.board.height)
                .map(player => player.x + "," + player.y)
        ).size;
    }

    private testForLoop(testedPose: Player) {
        if (history.length <= 1) { // don't block at start point
            return;
        }

        const forward = testedPose.forward();
        const assumedObstacle = new Point(forward.x, forward.y);
        const poseIfDetourHere = testedPose.turnRight();
        if (this.wouldThatLeadToExactPreviousPosition(poseIfDetourHere, false, assumedObstacle)) {
            const point = new Point(forward.x, forward.y);
            if (!this.isThatPointInHistory(point, this.history)) { // placing obstacle here would change the history!
                this._possibleLoopPlaces.add(point);
            }
        }
    }
    private updatePlayer(newPlayer: Player) {
        this._player = newPlayer;
        this._history.push(newPlayer);
    }

    private wasHereBefore(possiblePrevious: Player, history: Player[]): boolean {
        return history
            .filter(player => player.x == possiblePrevious.x && player.y == possiblePrevious.y && player.d == possiblePrevious.d)
            .length > 0;
    }

    private isThatPointInHistory(point: Point, history: Player[]) {
        return history
            .filter(entry => entry.x == point.x && entry.y == point.y)
            .length > 0;   
    }

    private wouldThatLeadToExactPreviousPosition(location: Player, log: boolean, assumedObstacle: Point) {
        let localHistory: Player[] = [];
        localHistory = localHistory.concat(this.history);

        let loc = location;
        for (;;) {
            if (this.board.isObstacle(loc.x, loc.y) || (assumedObstacle.x == loc.x && assumedObstacle.y == loc.y)) {
                loc = loc.backward().turnRight();
                continue;
            }           
            if (this.isOutsideBoard(loc, 0)) {
                return false;
            }
            if (this.wasHereBefore(loc, localHistory)) {
                return true;
            }
            localHistory.push(loc);
            loc = loc.forward();
        }

    }

    setAdditionalObstacle(x: number, y: number) {
        this._additionalObstacle = new Point(x, y);
    }

    isPlayerFollowingOwnSteps() {
        return this.wasHereBefore(this.player.forward(), this._history);
    }
}

