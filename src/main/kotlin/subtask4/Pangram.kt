package subtask4

class Pangram {

    fun getResult(sentence: String): String {
        val alphabet = "abcdefghijklmnopqrstuvwxyz"
        val vowels = "aeiouy"
        val consonants = "bcdfghjklmnpqrstvwxz"
        val sentenceWords: Array<String> = sentence.trim().split(" ").toTypedArray()
        var modifiedWord: String
        var maxSortingLettersNumber = 0
        var sortedSentenceWords: List<String> = emptyList()
        var isPangram = true

        if(sentence.trim() == "") return ""

        for (i in alphabet.indices)
            if (!(sentence.toLowerCase()).contains(alphabet[i])){
                isPangram = false
                break
            }

        if (isPangram){
            for (i in sentenceWords.indices){
                var vowelsNumber = 0
                modifiedWord = sentenceWords[i].trim()
                for (letter in modifiedWord)
                    if (vowels.contains(letter.toLowerCase())){
                        vowelsNumber++
                        modifiedWord = modifiedWord.replace(letter, letter.toUpperCase())
                    }
                if (modifiedWord != "") {
                    modifiedWord = vowelsNumber.toString() + modifiedWord
                    sentenceWords.set(i, modifiedWord)}

                if (vowelsNumber > maxSortingLettersNumber) maxSortingLettersNumber = vowelsNumber
            }
        }
        else{
            for (i in sentenceWords.indices){
                var consonantsNumber = 0
                modifiedWord = sentenceWords[i].trim()
                for (letter in modifiedWord)
                    if (consonants.contains(letter.toLowerCase())){
                        consonantsNumber++
                        modifiedWord = modifiedWord.replace(letter, letter.toUpperCase())
                    }
                if(modifiedWord != ""){
                    modifiedWord = consonantsNumber.toString() + modifiedWord
                    sentenceWords.set(i, modifiedWord)
                }
                if (consonantsNumber > maxSortingLettersNumber) maxSortingLettersNumber = consonantsNumber
            }
        }

        for(i in 0..maxSortingLettersNumber)
            for (word in sentenceWords.iterator()){
                if(word.take(1) == "$i")
                    sortedSentenceWords += word
            }

        return sortedSentenceWords.joinToString(" ")

    }
}