import {Player} from "@/model/player";
import {Board} from "@/model/board";

export class BoardRendererService {
    constructor(
        private borderCharacter: string = ' ') {
    }

    public renderBoardView(board: Board, player: Player): string {
        const lines = board.content.split("\n");
        let result = ""
        result += this.borderCharacter.repeat(board.width + 2);
        result += "\n";
        for (let y = 0; y < board.height; y++) {
            result += this.borderCharacter;
            for (let x = 0; x < board.width; x++) {
                result += (x == player.x && y == player.y) ? player.d : lines[y].substring(x, x + 1);
            }
            result += this.borderCharacter;
            result += "\n";
        }
        result += this.borderCharacter.repeat(board.width + 2);
        return result;
    }

}