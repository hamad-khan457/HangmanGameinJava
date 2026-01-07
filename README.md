# 🎮 Word Guessing Game

## 📝 Description

A fun and interactive **Word Guessing Game** built in Java as my first semester programming project. Players try to guess hidden words letter by letter, similar to the classic Hangman game, with a scoring system based on performance!

## ✨ Features

- 🎯 **Random Word Selection** - Words are randomly chosen from a predefined list
- 👤 **Personalized Experience** - Greets players by their first name
- 💡 **Smart Hints** - Shows first and last letters of the word
- 🎲 **Limited Chances** - Number of attempts based on word length
- 📊 **Scoring System** - Performance-based scoring out of 10
- 🔄 **Replay Option** - Play multiple rounds in one session
- 📚 **Word Bank** - Includes programming and computer science related terms

## 🎯 How to Play

1. **Enter Your Name** - The game will ask for your first name
2. **View the Word** - You'll see the first and last letters with blanks in between (e.g., `j___a`)
3. **Guess Letters** - Type one letter at a time to guess the word
4. **Track Your Progress** - Monitor remaining chances and revealed letters
5. **Win or Lose** - Complete the word before running out of chances
6. **Play Again** - Choose to play another round or exit

## 🎮 Gameplay Example

```
Enter your first name: Hamad
Word: j___
Chances left: 2
Guess a letter: a
Correct guess!
Word: ja_a
Chances left: 2
Guess a letter: v
Correct guess!
Hamad Congratulations! You guessed the word: java
Your score: 10.0
Do you want to play again? (1 for yes, 0 for no):
```

## 🏆 Scoring System

- **Maximum Score**: 10 points
- **Calculation**: `(Correct guesses / Total blanks) × 10`
- **Perfect Score**: Guess all letters correctly without mistakes
- **Score decreases** with each incorrect guess

## 🛠️ Technical Details

### Word Bank
The game includes 8 programming-related words:
- java
- python
- programming
- computer
- algorithm
- developer
- keyboard
- language

### Key Components

| Component | Description |
|-----------|-------------|
| `WORDS[]` | Array storing available words |
| `chooseRandomWord()` | Randomly selects a word from the array |
| `isCorrectGuess()` | Validates player's guess and updates the word |
| **Chances System** | Based on word length minus 2 |
| **StringBuilder** | Efficiently manages the guessed word display |

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, VS Code) or Terminal

### Steps

1. **Clone or Download** the repository
   ```bash
   git clone https://github.com/hamad-khan457/word-guessing-game.git
   ```

2. **Navigate to the project directory**
   ```bash
   cd word-guessing-game
   ```

3. **Compile the program**
   ```bash
   javac FinalWordGame.java
   ```

4. **Run the game**
   ```bash
   java FinalWordGame
   ```

## 💻 Code Structure

```java
FinalWordGame
├── WORDS[]                    // Word bank array
├── main()                     // Main game loop
├── chooseRandomWord()         // Random word selector
└── isCorrectGuess()           // Guess validation method
```

## 🎓 Learning Outcomes

This project helped me learn and implement:

- ✅ **Java Basics** - Variables, data types, and operators
- ✅ **Control Structures** - Loops (while, for) and conditional statements
- ✅ **Arrays** - Storing and accessing data
- ✅ **String Manipulation** - StringBuilder and String methods
- ✅ **Methods** - Creating and calling static methods
- ✅ **User Input** - Scanner class for user interaction
- ✅ **Random Number Generation** - Using Random class
- ✅ **Game Logic** - Implementing game flow and scoring


## 📸 Screenshots

### Game Start
```
Enter your first name: Hamad
Word: p______
Chances left: 5
Guess a letter:
```

### During Gameplay
```
Word: p_o___m
Chances left: 3
Guess a letter: r
Correct guess!
```

### Victory Screen
```
Hamad Congratulations! You guessed the word: program
Your score: 8.5
Do you want to play again? (1 for yes, 0 for no):
```

Made with ❤️ by Hamad Khan | First Semester Project</p>
</div>
