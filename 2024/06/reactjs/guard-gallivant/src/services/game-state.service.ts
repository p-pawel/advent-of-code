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
}