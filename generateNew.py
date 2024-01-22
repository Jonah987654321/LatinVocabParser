import csv

class Vocab:
    
    def __init__(self, latin, german, lesson, wordType, wordTypeSpec) -> None:
        self.latin = latin
        self.german = german
        self.lesson = lesson
        self.wordType = wordType
        self.wordTypeSpec = wordTypeSpec

verbs = []
nouns = []
adjectives = []
other = []

def valueOrNone(target, index):
    try:
        return target[index]
    except:
        return None

with open("voc_list.csv", encoding="UTF-8") as file:
    for line in file:
        data = line.strip("\n").split(";")
        vocab = Vocab(data[0], data[1].split(","), data[3], data[2].split(", ")[0], valueOrNone(data[2].split(", "), 1))
        if vocab.wordType == "Substantiv":
            nouns.append(vocab)
        elif vocab.wordType == "Verb":
            verbs.append(vocab)
        elif vocab.wordType == "Adjektiv":
            adjectives.append(vocab)
        else:
            other.append(vocab)

with open("verbs.csv", "+w") as file:
    writer = csv.writer(file, delimiter=";")
    for vocab in verbs:
        baseform = vocab.latin.split(", ")

        if baseform[0].endswith("re"):

            if(len(baseform) == 1):
                if baseform[0].endswith("are"):
                    writer.writerow([baseform[0], baseform[0][:-3]])
                else:
                    writer.writerow([baseform[0], baseform[0][:-2]])
            else:
                writer.writerow([baseform[0], baseform[1][:-1]])
