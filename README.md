# 🎮 Advanced Hangman Game

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/API-Integration-green?style=for-the-badge" alt="API"/>
  <img src="https://img.shields.io/badge/File_I/O-Enabled-blue?style=for-the-badge" alt="File I/O"/>
  <img src="https://img.shields.io/badge/Status-Complete-success?style=for-the-badge" alt="Status"/>
</div>

## 📝 Description

An **enhanced word guessing game** (Hangman) built in Java with advanced features including **API integration**, **persistent score tracking**, and **internet connectivity detection**. This project demonstrates core Java concepts along with modern programming practices like API consumption and file handling.

## ✨ Key Features

### 🌐 Smart Word Selection
- **Dynamic API Integration** - Fetches random words from an external API when online
- **Fallback System** - Uses local word bank when internet is unavailable
- **Automatic Detection** - Checks internet connectivity before each game

### 💾 Data Persistence
- **Score Tracking** - Saves player names, words, and scores to a file
- **Game History** - Maintains a record of all games played
- **Persistent Storage** - Data survives program restarts

### 🎯 Gameplay Features
- **Personalized Experience** - Greets players by name with proper capitalization
- **Smart Hints** - Reveals first and last letters
- **Dynamic Difficulty** - Chances based on word length
- **Performance Scoring** - Calculate scores out of 10
- **Replay Option** - Play multiple rounds seamlessly
- **Error Handling** - Robust input validation and exception handling

## 🎮 How to Play

1. **Enter Your Name** - Type your first name to begin
2. **View the Word** - First and last letters are visible (e.g., `j___a`)
3. **Guess Letters** - Enter one letter at a time
4. **Track Progress** - Monitor remaining chances and score
5. **Complete or Fail** - Either guess the word or run out of chances
6. **Review Results** - Your score is automatically saved
7. **Play Again** - Choose to continue or exit

## 🎯 Gameplay Example

```
Enter your first name: hamad
Word: p_______
Chances left: 8
Guess a letter: r
Correct guess!
Word: pr______
Chances left: 8
Guess a letter: o
Correct guess!
Word: pro_____
Chances left: 8
Guess a letter: g
Correct guess!
...
Hamad  Congratulations! You guessed the word: program
Your score: 8.75
Player information saved.
Do you want to play again? (1 for yes, 0 for no):
```

## 🏆 Scoring System

```java
Score = (Correct Guesses / Total Blanks) × 10
```

- **Maximum Score**: 10.0 points
- **Perfect Game**: Guess without any incorrect attempts
- **Score Penalty**: Each wrong guess reduces your final score
- **Automatic Save**: All scores are saved to `hangman_scores.txt`

## 🛠️ Technical Architecture

### Core Components

| Component | Functionality |
|-----------|---------------|
| `getRandomWordFromApi()` | Fetches words from external API |
| `chooseRandomWordFromArray()` | Selects from local word bank |
| `isInternetAvailable()` | Checks network connectivity |
| `isCorrectGuess()` | Validates player input |
| `savePlayerInfo()` | Persists game data to file |

### Technology Stack

- **Java Standard Library** - Core functionality
- **java.net** - HTTP connections and API calls
- **java.io** - File operations and data persistence
- **java.util** - Utilities (Scanner, Random)
- **Exception Handling** - InputMismatchException, IOException

### API Integration

```java
API: https://random-word-api.herokuapp.com/word?number=1
Method: GET
Response: JSON array with random word
Fallback: Local word array
```

### File Storage

**File**: `hangman_scores.txt`  
**Format**: `PlayerName : Word : Score`  
**Mode**: Append (preserves history)

```
Hamad     :       java      :     10.0
Ali       :       programming      :     7.5
Sara      :       computer      :     8.333333
```

## 🚀 Installation & Setup

### Prerequisites

- **Java JDK** 8 or higher
- **Internet Connection** (optional - for API features)
- **Text Editor** or IDE (IntelliJ IDEA, Eclipse, VS Code)

### Steps to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/hamad-khan457/hangman-game.git
   cd hangman-game
   ```

2. **Compile the Program**
   ```bash
   javac HangmanGame.java
   ```

3. **Run the Game**
   ```bash
   java HangmanGame
   ```

4. **View Saved Scores** (after playing)
   ```bash
   cat hangman_scores.txt
   # or
   type hangman_scores.txt  # Windows
   ```

## 💻 Project Structure

```
hangman-game/
├── HangmanGame.java           # Main game file
├── hangman_scores.txt         # Score storage (auto-generated)
└── README.md                  # This file
```

### Code Architecture

```java
HangmanGame
├── Constants
│   ├── WORDS[]                // Local word bank
│   ├── SCORE_FILE             // Score file path
│   └── RANDOM_WORD_API        // API endpoint
├── Main Game Loop
│   └── main()                 // Entry point
├── Game Logic
│   ├── isCorrectGuess()       // Validates guesses
│   └── getRandomWordFromApi() // Fetches API words
├── Utility Methods
│   ├── chooseRandomWordFromArray()
│   └── isInternetAvailable()  // Connectivity check
└── Data Persistence
    └── savePlayerInfo()       // Saves to file
```

## 🎓 Learning Outcomes

This project demonstrates proficiency in:

### Core Java Concepts
- ✅ **Object-Oriented Programming** - Classes and methods
- ✅ **Control Flow** - Loops, conditionals, and logic
- ✅ **Data Structures** - Arrays and StringBuilder
- ✅ **Exception Handling** - Try-catch blocks

### Advanced Topics
- ✅ **API Integration** - HTTP requests and JSON parsing
- ✅ **File I/O Operations** - Reading and writing files
- ✅ **Network Programming** - URL connections and streams
- ✅ **Error Handling** - Input validation and graceful failures
- ✅ **Resource Management** - try-with-resources pattern

## 📊 Feature Comparison

| Feature | Basic Version | Advanced Version |
|---------|---------------|------------------|
| Word Source | Local Array | API + Fallback |
| Score Tracking | Console Only | File Storage |
| Internet Check | ❌ | ✅ |
| Error Handling | Basic | Comprehensive |
| Data Persistence | ❌ | ✅ |
| Input Validation | Basic | Advanced |


## 🐛 Error Handling

The game handles various error scenarios:

| Error Type | Handling |
|------------|----------|
| **Invalid Input** | InputMismatchException caught and handled |
| **No Internet** | Automatic fallback to local words |
| **File Write Error** | IOException caught, error message displayed |
| **API Failure** | Falls back to local word array |
| **Invalid File Path** | Creates new file if missing |

## 📸 Sample Output

### Successful Game
```
Enter your first name: hamad
Word: j___
Chances left: 2
Guess a letter: a
Correct guess!
Word: ja_a
Chances left: 2
Guess a letter: v
Correct guess!
Hamad  Congratulations! You guessed the word: java
Your score: 10.0
Player information saved.
Do you want to play again? (1 for yes, 0 for no): 0
Hamad  Goodbye!
```

### Failed Game
```
Word: p_______
Chances left: 1
Guess a letter: x
Incorrect guess. Chances left: 0
You did not guessed the word. The correct word is : program
Player information saved.
Do you want to play again? (1 for yes, 0 for no):
```

### Score File Content
```
Hamad     :       java      :     10.0
Ali       :       python      :     6.0
Sara      :       computer      :     8.333333
Ahmed     :       algorithm      :     7.777778
```

## 🔧 Configuration

### Customizing Word Bank

Edit the `WORDS` array to add your own words:

```java
private static final String[] WORDS = {
    "java", "python", "programming", 
    "computer", "algorithm", "developer",
    // Add your words here
    "machine", "learning", "artificial"
};
```

### Changing API Source

Modify the API URL constant:

```java
private static final String RANDOM_WORD_API = 
    "https://your-api-url.com/word?number=1";
```

### Custom Score File Location

Change the file path:

```java
private static final String SCORE_FILE = 
    "/path/to/your/scores.txt";
```
