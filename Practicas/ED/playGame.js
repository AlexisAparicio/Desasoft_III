const countSymbolsInBoard = (board, symbol) => board
  .reduce((previousRowCount, currentRow) => {
    return previousRowCount + currentRow
      .filter(v => v === symbol).length
  }, 0)

  const copyBoard = board => [
    [board[0][0], board[0][1], board[0][2]],
    [board[1][0], board[1][1], board[1][2]],
    [board[2][0], board[2][1], board[2][2]],
  ]

  const symbolX = 'X'
const symbolO = 'O'

export const isDraw = (board) => board.flat().every(v => v === symbolO || v === symbolX)
    export const winningCoordinates = [
        [
          [0, 0], [0, 1], [0, 2],
        ],
        [
          [1, 0], [1, 1], [1, 2],
        ],
        [
          [2, 0], [2, 1], [2, 2],
        ],
        [
          [0, 0], [1, 0], [2, 0],
        ],
        [
          [0, 1], [1, 1], [2, 1],
        ],
        [
          [0, 2], [1, 2], [2, 2],
        ],
        [
          [0, 0], [1, 1], [2, 2],
        ],
        [
          [2, 0], [1, 1], [0, 2],
        ]
      ]
      
      export const hasWon = (currentBoard, isX) => {
        const checkingSymbol = isX ? symbolX : symbolO
      
        for (let coordTriple of winningCoordinates) {
          const symbolTriple = coordTriple.map(coords => currentBoard[coords[0]][coords[1]])
          if (symbolTriple.every(v => v === checkingSymbol)) {
            return true
          }
        }
      
        return false
      }
      export const doTurn = (currentBoard, isX, x, y) => {
        if (isDraw(currentBoard)) {
          throw new Error('Cannot move on board that is a draw')
        }
      
        if (hasWon(currentBoard, true) || hasWon(currentBoard, false)) {
          throw new Error('Cannot move on board that was already won by someone')
        }
      
        if (x > 2 || y > 2) {
          throw new Error(`Coordinates out of bounds: ${x}/${y}`)
        }
      
        if (currentBoard[y][x] === symbolX || currentBoard[y][x] === symbolO) {
          throw new Error(`Illegal move: ${x}/${y} is already occupied`)
        }
      
        const numberOFXs = countSymbolsInBoard(currentBoard, symbolX)
        const numberOFOs = countSymbolsInBoard(currentBoard, symbolO)
      
        if ((isX && numberOFXs > numberOFOs) || (!isX && numberOFOs > numberOFXs)) {
          throw new Error(`Illegal move, it would be ${(isX ? 'O' : 'X')}s turn`)
        }
      
        const newBoard = copyBoard(currentBoard)
      
        newBoard[y][x] = isX ? symbolX : symbolO
      
        return newBoard
      }

      import { doTurn, hasWon, isDraw } from './game.js'
import { createInterface } from 'readline'

const playGame = async () => {
  let isX = true

  let board = [
    ['', '', ''],
    ['', '', ''],
    ['', '', ''],
  ]

  const rl = createInterface({
    input: process.stdin,
    output: process.stdout
  })

  const getInput = question => new Promise(resolve => {
    rl.question(question, resolve)
  })

  while (!hasWon(board, true) && !hasWon(board, false) && !isDraw(board)) {
    console.table(board)
    console.log(`${isX ? 'X' : 'O'}s turn!\n`)

    const x = Number(await getInput('X coordinate: '))
    const y = Number(await getInput('Y coordinate: '))
    try {
      board = doTurn(board, isX, x, y)

      isX = !isX
    } catch (e) {
      console.warn(e.message)
    }
  }

  console.table(board)
  console.log('----------')
  console.log(isDraw(board) ? 'Draw!' : hasWon(board, true) ? 'X has won!' : 'Y has won!')

  process.exit(0)
}

playGame()