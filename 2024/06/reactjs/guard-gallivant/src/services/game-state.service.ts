import {Board} from "@/model/board";
import {Player} from "@/model/player";

export class GameStateService {
    private _board: Board;
    private _player!: Player;
    private _history: Player[] = [];

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

    public move() {
        let newPlayer = this.player.forward();
        if (this.isOutsideBoard(newPlayer, 1)) {
            return
        }

        if (!this.board.isObstacle(newPlayer.x, newPlayer.y)) {
            this.updatePlayer(newPlayer);
        } else {
            this.updatePlayer(this.player.turnRight());
        }
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

    private updatePlayer(newPlayer: Player) {
        this._player = newPlayer;
        this._history.push(newPlayer);
    }
}