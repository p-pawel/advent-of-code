import {Board} from "@/model/board";
import {Player} from "@/model/player";

export class GameStateService {
    private _board: Board;
    private _player: Player;

    constructor(
        private inputString: string
    ) {
        this._board = new Board(inputString);
        this._player = Player.fromTheInputBoard(inputString);
    }


    get board(): Board {
        return this._board;
    }


    get player(): Player {
        return this._player;
    }

    public move() {
        let newPlayer = this.player.forward();
        if (this.isOutsideBoard(newPlayer, 1)) {
            return
        }

        if (!this.board.isObstacle(newPlayer.x, newPlayer.y)) {
            this._player = newPlayer;
        } else {
            this._player = this.player.turnRight();
        }
    }

    private isOutsideBoard(newPlayer: Player, margin: number) {
        return newPlayer.x < -margin || newPlayer.y < -margin || newPlayer.x >= this.board.width + margin || newPlayer.y >= this.board.height +margin;
    }

    isPlayerWithinBoard() {
        return !this.isOutsideBoard(this.player, 0);
    }
}