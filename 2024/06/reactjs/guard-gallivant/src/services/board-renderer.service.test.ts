import {describe, expect, it} from "@jest/globals";
import {BoardRendererService} from "@/services/board-renderer.service";
import {Player} from "@/model/player";
import {Board} from "@/model/board";

describe('BoardRendererService', () => {

    it('should redner board from the example', async () => {

        // arrange

        const inputString = "....#.....\n" +
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

        const user = boardRenderer.renderBoardView(board, player, [], undefined);

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

    it('should redner player on the bottom border', async () => {

        // arrange
        
        const inputString =
            "...\n" +
            "...\n" +
            "...";

        const board: Board = new Board(inputString);

        const player: Player = new Player(1, 3, 'v');

        const boardRenderer = new BoardRendererService(' ');

        // act

        const user = boardRenderer.renderBoardView(board, player, [], undefined);

        // assert

        expect(user).toEqual(
            "     \n" +
            " ... \n" +
            " ... \n" +
            " ... \n" +
            "  v  "
        );
    });

    it('should redner some history', async () => {

        // arrange
        
        const inputString =
            "...\n" +
            "...\n" +
            "...";

        const board: Board = new Board(inputString);

        const player: Player = new Player(1, 3, 'v');

        const boardRenderer = new BoardRendererService(' ');

        // act

        const history = [
            new Player(0, 0, '>'),
            new Player(1, 0, 'v'),
            new Player(1, 1, 'v'),
            new Player(1, 2, 'v'),
        ];
        
        const user = boardRenderer.renderBoardView(board, player, history, undefined);

        // assert

        expect(user).toEqual(
            "     \n" +
            " >v. \n" +
            " .v. \n" +
            " .v. \n" +
            "  v  "
        );
    });


});