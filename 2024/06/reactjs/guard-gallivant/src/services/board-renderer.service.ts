import {Player} from "@/model/player";
import {Board} from "@/model/board";
import {Point} from "@/model/point";

export class BoardRendererService {
    constructor(
        private borderCharacter: string = ' ') {
    }

    public renderBoardView(board: Board, player: Player, history: Player[], additionalObstacle?: Point): string {
        const board2d: string[][] = board.content.split("\n")
            .map(line => line.split(''));
        
        history
            .filter(position => position.x >=0 && position.y >=0 && position.x < board.width && position.y < board.height)
            .forEach(position => board2d[position.y][position.x] = position.d);
        
        if (additionalObstacle) {
            board2d[additionalObstacle.y][additionalObstacle.x] = 'O';
        }

        
        let result = ""
        result += this.borderCharacter;
        for (let x = 0; x < board.width; x++) {
            result += (x == player.x && -1 == player.y) ? player.d : this.borderCharacter;
        }
        result += this.borderCharacter;

        result += "\n";
        for (let y = 0; y < board.height; y++) {
            result += (-1 == player.x && y == player.y) ? player.d : this.borderCharacter;
            for (let x = 0; x < board.width; x++) {
                result += (x == player.x && y == player.y) ? player.d : board2d[y][x];
            }
            result += (board.width == player.x && y == player.y) ? player.d : this.borderCharacter;
            result += "\n";
        }

        result += this.borderCharacter;
        for (let x = 0; x < board.width; x++) {
            result += (x == player.x && board.height == player.y) ? player.d : this.borderCharacter;
        }
        result += this.borderCharacter;
        
        return result;
    }

}