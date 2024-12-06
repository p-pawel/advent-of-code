import {describe, expect, it} from "@jest/globals";
import {BoardRendererService} from "@/services/board-renderer.service";
import {Player} from "@/model/player";
import {Board} from "@/model/board";

describe('BoardRendererService', () => {

    it('should redner board from the example', async () => {
        
        // arrange
        
        let inputString = "....#.....\n" +
            ".........#\n" +
            "..........\n" +
            "..#.......\n" +
            ".......#..\n" +
            "..........\n" +
            ".#..^.....\n" +
            "........#.\n" +
            "#.........\n" +
            "......#...";
        
        const board: Board = new Board(inputString);
        
        const player: Player = Player.fromTheInputBoard(inputString);
        
        const boardRenderer = new BoardRendererService(' ');
        
        // act

        const user = boardRenderer.renderBoardView(board, player);

        // assert

        expect(user).toEqual(
            "            \n" +
            " ....#..... \n" +
            " .........# \n" +
            " .......... \n" +
            " ..#....... \n" +
            " .......#.. \n" +
            " .......... \n" +
            " .#..^..... \n" +
            " ........#. \n" +
            " #......... \n" +
            " ......#... \n" +
            "            ");
    });

    
});