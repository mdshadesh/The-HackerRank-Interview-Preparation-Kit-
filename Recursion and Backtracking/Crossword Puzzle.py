solution = []
spaces = []
blanks = []

class Space:
    def __init__(self, start, length, vertical, taken):
        self.start = start
        self.length = length
        self.vertical = vertical
        self.taken = taken

def main():
    solution, spaces = readGrid() #reads the input and saves grid to solution and spaces variables
    words = set(input().split(';')) #breaks input separated by semicolons and stores in words variable
    findSol(solution, spaces, words) #computes solution based on input grid and words
    for row in solution:
        print("".join(row))#prints solved grid solution line-by-line

def readGrid():
    '''Reads the grid and finds the spaces in the rows and columns'''
    rows = []
    for i in range(10):
        row = input()
        rows.append(row)
    row_spaces = countSpaces(rows)
    cols = []
    for x in range(10):
        col = ""
        for y in range(10):
            col += rows[y][x]
        cols.append(col)
    col_spaces = countSpaces(cols, vertical = True)
    return [list(row) for row in rows], row_spaces + col_spaces

def countSpaces(lines, vertical=False):
    '''Takes in a line of the grid and counts the spaces, and stores them in an array.
       The input vertical has the value True if the line is a column.'''
    spaces = []
    n = 0
    for line in lines:
        for j in whereAreSpaces(line):
            index, length = j
            if (vertical == True):
                start = (index, n)
            else:
                start = (n, index)
            spaces.append(Space(start, length, vertical, False))
        n += 1
    return spaces

def whereAreSpaces(line):
    '''Finds the spaces in the line and appends a tuple of the index and length to spaces'''
    spaces = []
    for blanks in line.split("+"):
        length = len(blanks)
        if length > 1:
            index = 0
            while index < length:
                index = line.find(blanks, index)
                if line == -1:
                    break
                spaces.append((index, length))#appends the tuple of index and length to spaces array
                index += length
    return spaces

def findSol(grid, spaces, words):
    '''Finds the solution of the puzzle. If words is empty (len 0), returns
       True to indicate that the puzzle is solved.'''
    if len(words) == 0:
        return True
    for word in words:
        for space in spaces:
            if canAddWord(grid, space, word):
                before = addWord(grid, space, word)
                space.taken = True
                new_words = set(words)
                new_words.remove(word)
                if findSol(grid, spaces, new_words):
                    return True
                addWord(grid, space, before) #will revert the grid if the solution is incorrect
                space.taken = False

    return False

def canAddWord(grid, space, word):
    '''Returns true if that word can be added to that place in the grid and
        returns false if it cannot'''
    if space.taken or len(word) != space.length:
        return False
    row, col = space.start
    for i in word:
        if not (grid[row][col] == "-" or grid[row][col] == i):
            return False
        row, col = nextSpace(row, col, space.vertical)
    return True

def addWord(grid, space, word):
    '''adds the given word to the grid and returns the new grid'''
    new_grid = []
    row, col = space.start
    for char in word:
        new_grid.append(grid[row][col])
        grid[row][col] = char
        row, col = nextSpace(row, col, space.vertical)
    return new_grid

def nextSpace(row, col, vertical):
    '''Returns the position of the next space, whether its vertical or horizontal'''
    if vertical is True:
        return (row + 1), col
    else:
        return row, (col + 1)


main()