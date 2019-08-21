/*
"Pattern Analysis Tool (Pat)" << Alpha v 1.0 >>
Written by J.D. Shaeffer
Commisioned personally by Tom McDermott, CTO of Derive Tek

This program is a really unintelligent artificial intelligence (if you could even call it that).
Built via a large system of conditionals, it takes three expressions (exp1, exp2, exp3) and three user-driven analyses (anl1, anl2, anl3).
It then combines them to tell the user something of their subconcious.
Useful for finding passions, curiosities, wonderings, and other psychological analyses.
*/

//NOTE: include for the pattern - ex: if exp1 or exp2 or exp3 is "Romance", then print out statement generated for "Romance"

import java.util.Scanner;

class Patterns
{
    static String story; //each story will be assigned this value
    static String exp1, exp2, exp3; //these values will help determine the pattern associated with the explanations and wonderings
    static String anl1, anl2, anl3; //variables to give to each analysis
    static String x; //global variables useful for static methods and input
    static int i; //count variable used for generating the different conversation combinations
    
    static void question() //function ran every time user asks a question (contains a '?' in their response)
    { //this is really to alleviate the intelligence of the tool, not having to answer questions
        if(i == 1)
        System.out.println("Sorry I don't mean to be rude, but if I may, I'll be asking the questions.");
        else if(i == 2)
            System.out.println("Sorry, I'm afraid I can't answer that right now. Please proceed with your answer.");
        else if(i == 3)
            System.out.println("My apologies, but I'm not able to give you an answer there. Please continue.");
        else if(i == 4)
            System.out.println("I apologize but I can't answer your question right now. Please go on with your answer.");
        else if(i == 5)
        {
            System.out.println("I don't mean to hurt your feelings, but I'm really not good at answering questions.");
            i = 1;
        }
    }
    
    static void genericElse() //function ran when reading an unexpected response
    {
        if(i == 1)
            System.out.println("Sorry, didn't catch that.");
        else if(i == 2)
            System.out.println("I didn't get that, sorry.");
        else if(i == 3)
            System.out.println("What was that?");
        else if(i == 4)
            System.out.println("I didn't understand that. Try again please?");
        else if(i == 5)
        {
            System.out.println("Wait, I don't understand what you just said.");
            i = 1;
        }
    }

    static void getAnalysis() //function ran for the 2nd and 3rd prompts for self-analysis
    {
        if(i == 1)
            System.out.println("Having said that, what does that make you wonder about yourself?");
        else if(i == 2)
            System.out.println("What do you think that statement says about yourself?");
        else if(i == 3)
            System.out.println("What can you say about yourself based on that statement?");
        else if(i == 4)
            System.out.println("Based on that answer, what could you say about yourself?");
        else if(i == 5)
        {
            System.out.println("Saying that, what does that make you wonder about yourself? Anything curious?");
            i = 1;
        }
    }

    static void prompt() //function ran for the 2nd and 3rd prompts for favorite story
    {
        if(i == 1)
            System.out.println("Awesome. What is another one of your favorite books/movies?");
        else if(i == 2)
            System.out.println("Okay, another question for you. If you could please tell me, what is another one of your favorite books/movies?");
        else if(i == 3)
            System.out.println("What is another one of your favorite books/movies?");
        else if(i == 4)
            System.out.println("Please, what is another one of your favorite books/movies?");
        else if(i == 5)
        {
            System.out.println("Now, tell me again. What is another one of your favorite books/movies?");
            i = 1;
        }
    }
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        i = 1; //5 different responses for every possible return -> organic conversation
        boolean start = true, feeling = false, declaration1 = false, explanation1 = false, declaration2 = false, explanation2 = false, declaration3 = false, explanation3 = false, end = false;
        
        System.out.println("Hi! What's your name?"); //Pat has an enthusiastic and boisterous personality
        System.out.print(">"); //prompt for user input
        String name = scan.nextLine();
        System.out.println(name + "? Is this correct?");
        System.out.print(">");
        x = scan.nextLine().toLowerCase();

        while(true) //while loop logic as discovered while making TBAGs (Text Based Adventure Game(s))
        {
            while(start)
            {
                if(x.contains("?")) //assuming a question response
                    question();
                else if(x.equals("yes")||x.equals("y")||x.contains("ye")||x.contains("sure"))
                {
                    if(i == 1)
                    {
                        System.out.println("Awesome. It's a lovely name. I'm Pat.\n"
                                + "How are you doing?");
                        feeling = true; start = false;
                    }
                    else if(i == 2)
                    {
                        System.out.println("Excellent! Glad to meet you. My name is Pat.\n"
                                + "How are you?");
                        feeling = true; start = false;
                    }
                    else if(i == 3)
                    {
                        System.out.println("I like that name. I'm Pat. It's good to meet you.\n"
                                + "How are you doing?");
                        feeling = true; start = false;
                    }
                    else if(i == 4)
                    {
                        System.out.println("It's a pleasure to meet you " + name + ". I'm Pat.\n"
                                + "How are you?");
                        feeling = true; start = false;
                    }
                    else if(i == 5)
                    {
                        System.out.println("Hello, " + name + ". I'm Pat. It's a pleasure.\n"
                                + "How are you doing?");
                        i = 1; //reset
                        feeling = true; start = false;
                    }
                }   
                else if(x.equals("no")||x.equals("n")||x.contains("no"))
                {
                    System.out.println("Alright, no trouble. What's your name?");
                    System.out.print(">");
                    name = scan.nextLine();
                    System.out.println(name + "? Is this correct?");
                }
                else
                    genericElse();
                System.out.print(">");
                x = scan.nextLine().toLowerCase();
                i++;
            }

            ///////////////////////////////////////////////////////////////////////////////////////
            
            while(feeling)
            {
                if(x.contains("?"))
                    question();
                else if(x.contains("not bad")||x.contains("good")||x.contains("fine")||x.contains("excellent")||x.contains("stupendous")||x.contains("awesome")||x.contains("okay")||x.contains("well")||x.contains("alright"))
                {
                    if(i == 1)
                    {
                        System.out.println("Good to hear!\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "Now, what is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? That's the one?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 2)
                    {
                        System.out.println("Awesome! Same here.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "Question for you. If you could please tell me, what is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is that right?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 3)
                    {
                        System.out.println("Excellent. I'm happy you're doing well.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "What is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? That's it, right?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 4)
                    {
                        System.out.println("Great! Doing fine here too.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "What is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Did I get that right?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 5)
                    {
                        System.out.println("Wonderful. I'm glad you're fine.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "Now, please tell me. What is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        i = 1;
                        declaration1 = true; feeling = false;
                    }
                }
                else if(x.contains("bad")||x.contains("not good")||x.contains("terrible")||x.contains("crappy")||x.contains("crummy")||x.contains("not "))
                {
                    if(i == 1)
                    {
                        System.out.println("I'm sorry to hear that. Hopefully I can cheer you up.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "What is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? That's the one?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 2)
                    {
                        System.out.println("Hey, it's alright. I understand.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "If you could please tell me, what is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is that right?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 3)
                    {
                        System.out.println("Oh, okay. I hope you can get out of your slump.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "What is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? That's it, right?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 4)
                    {
                        System.out.println("Oh I'm sorry. It'll be alright.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "Now, what is one of your favorite books/movies.");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Did I get that right?");
                        declaration1 = true; feeling = false;
                    }
                    else if(i == 5)
                    {
                        System.out.println("That's unfortunate. I'm sure everything will be okay.\nSo, I'll ask you three times for your favorite books or movies. Let's get started!\n"
                                + "Now, please tell me. What is one of your favorite books/movies?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        i = 1; //reset
                        declaration1 = true; feeling = false;
                    }
                }
                else
                    genericElse();
                System.out.print(">");
                x = scan.nextLine().toLowerCase();
                i++;
            }

            ///////////////////////////////////////////////////////////////////////////////////////
            
            while(declaration1 || declaration2 || declaration3)
            {
                if(x.contains("?"))
                    question();
                else if(x.equals("yes")||x.equals("y")||x.contains("ye"))
                {
                    if(i == 1)
                    {
                        System.out.println("Awesome. " + story + " is truly one of my favorites too.\n"
                                + "What's most intriguing about it for you?");
                        if(declaration1)
                        {
                            explanation1 = true; declaration1 = false;
                        }
                        else if(declaration2)
                        {
                            explanation2 = true; declaration2 = false;
                        }
                        else if(declaration3)
                        {
                            explanation3 = true; declaration3 = false;
                        }
                    }
                    else if(i == 2)
                    {
                        System.out.println("Excellent. I'm glad you like " + story + ". One of my favorites as well.\n"
                                + "What do you love most about it?");
                        if(declaration1)
                        {
                            explanation1 = true; declaration1 = false;
                        }
                        else if(declaration2)
                        {
                            explanation2 = true; declaration2 = false;
                        }
                        else if(declaration3)
                        {
                            explanation3 = true; declaration3 = false;
                        }
                    }
                    else if(i == 3)
                    {
                        System.out.println("Sweet. What do you like most about it?");
                        if(declaration1)
                        {
                            explanation1 = true; declaration1 = false;
                        }
                        else if(declaration2)
                        {
                            explanation2 = true; declaration2 = false;
                        }
                        else if(declaration3)
                        {
                            explanation3 = true; declaration3 = false;
                        }
                    }
                    else if(i == 4)
                    {
                        System.out.println("Wonderful. " + story + " is one of my favorites too.\n"
                                + "What's most intriguing about it for you?");
                        if(declaration1)
                        {
                            explanation1 = true; declaration1 = false;
                        }
                        else if(declaration2)
                        {
                            explanation2 = true; declaration2 = false;
                        }
                        else if(declaration3)
                        {
                            explanation3 = true; declaration3 = false;
                        }
                    }
                    else if(i == 5)
                    {
                        System.out.println("Cool. What is most intriguing about it for you?");
                        if(declaration1)
                        {
                            i = 1; //reset
                            explanation1 = true; declaration1 = false;
                        }
                        else if(declaration2)
                        {
                            i = 1; //reset
                            explanation2 = true; declaration2 = false;
                        }
                        else if(declaration3)
                        {
                            i = 1; //reset
                            explanation3 = true; declaration3 = false;
                        }
                    }
                }   
                else if(x.equals("no")||x.equals("n")||x.contains("no"))
                {
                    if(i == 1 || i == 3)
                    {
                        System.out.println("Alright, no trouble. What is it?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                    }
                    else if(i == 2 || i == 4 || i == 5)
                    {
                        System.out.println("Oh my bad. What is it, then?");
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this right?");
                        if(i == 5)
                            i = 1;
                    }
                }
                else
                    genericElse();
                System.out.print(">");
                x = scan.nextLine().toLowerCase();
                i++;
            }

            ///////////////////////////////////////////////////////////////////////////////////////
            
            //!!!!!! IMPORTANT !!!!!!
            //This is the main section of the code that requires testing.
            //Everything runs fine, however, this can be significantly added upon.
            //The more keywords that are coded, the more "intelligent" Pat will be.

            while(explanation1 || explanation2 || explanation3)
            {
                if(x.contains("?"))
                    question();
                else if(x.contains("romance")||x.contains("romantic"))
                {
                    System.out.println("Ahh, the longing for love.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Romance";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Romance";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Romance";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("power")||x.contains("strong"))
                {
                    System.out.println("Interesting. Strength and power.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Power";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Power";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Power";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("happy")||x.contains("joy")||x.contains("cheerful"))
                {
                    System.out.println("Wonderful! Nothing quite like a cheerful, happy story.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Happiness";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Happiness";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Happiness";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("sad")||x.contains("depressed")||x.contains("melancholy"))
                {
                    System.out.println("Oh, yes. I understand the feeling.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Sadness";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Sadness";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Sadness";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("travel")||x.contains("explor"))
                {
                    System.out.println("Yes, of course. The innate desire to explore and travel.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Wanderlust";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Wanderlust";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Wanderlust";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("angry")||x.contains("anger")||x.contains("frustrated"))
                {
                    System.out.println("Absolutely. Stories can really move you to those deep feelings of anger.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Anger";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Anger";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Anger";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("fear")||x.contains("afraid")||x.contains("scary")||x.contains("horror"))
                {
                    System.out.println("Oh yeah, I like a good horror story too.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Fear";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Fear";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Fear";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("amazing")||x.contains("interesting")||x.contains("intriguing")||x.contains("cool "))
                {
                    System.out.println("Yeah, a story can really fill you with interesting and amazing thoughts.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Awe";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Awe";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Awe";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("entertain"))
                {
                    System.out.println("Wonderful. If it's entertaining to you, then it's perfect.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Entertainment";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Entertainment";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Entertainment";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("beauty")||x.contains("beautiful")||x.contains("art ")||x.contains("refined"))
                {
                    System.out.println("I'm glad you said that. I too enjoy the beauty in such stories.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Beauty";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Beauty";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Beauty";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("inspir"))
                {
                    System.out.println("It was inspirational? Wonderful.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Inspiration";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Inspiration";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Inspiration";
                        System.out.println("Okay. We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("magic")||x.contains("fantasy")||x.contains("virtual reality"))
                {
                    System.out.println("The longing to participate in those fantasy worlds is an intoxicating feeling, no? I understand.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Fantasy";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Fantasy";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Fantasy";
                        System.out.println("Thank you. Okay! We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("comedy")||x.contains("funny")||x.contains("hilarious")||x.contains("humor"))
                {
                    System.out.println("Of course! I love a funny story.");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Humor";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Humor";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Humor";
                        System.out.println("Thank you. Okay! We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else if(x.contains("fun")||x.contains("enjoyable"))
                {
                    System.out.println("Oh, you thought it was fun and enjoyable. I understand. Wonderful!");
                    getAnalysis();
                    System.out.print(">");
                    if(explanation1)
                    {
                        anl1 = scan.nextLine();
                        exp1 = "Fun";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration2 = true; explanation1 = false;
                    }
                    else if(explanation2)
                    {
                        anl2 = scan.nextLine();
                        exp2 = "Fun";
                        prompt();
                        System.out.print(">");
                        story = scan.nextLine();
                        System.out.println(story + "? Is this correct?");
                        declaration3 = true; explanation2 = false;
                    }
                    else if(explanation3)
                    {
                        anl3 = scan.nextLine();
                        exp3 = "Fun";
                        System.out.println("Thank you. Okay! We've reached the end of our conversation. Ready to see some results I've ascertained?");
                        end = true; explanation3 = false;
                    }
                }
                else
                    genericElse();
                System.out.print(">");
                x = scan.nextLine().toLowerCase();
                i++;
            }

            ///////////////////////////////////////////////////////////////////////////////////////

            while(end)
            {
                if(x.contains("?"))
                    question();
                else if(x.equals("yes")||x.equals("y")||x.contains("ye")||x.contains("sure"))
                {
                	// !!!! IMPORTANT !!!!
                	//Also here is a main point of pattern analysis.
                	//This is where Tom's psycho analysis skills would come in handy.
                	//Here is where we can hard code combinations of the three expressions to attach patterns.
                	//For now, it's just stating what was written by the user.
                	//Soon, Pat will be able to attach a core feeling/action that takes place inside the user based on the three analyses and expressions.
                	//This could mean more key word logic inside the analyses, not just the expressions.
                    
                    System.out.println("Fabulous! These were the three core feelings, attached to your analyses, that I found located in your subconcious:");
                    System.out.println("1) " + exp1 + "\t" + anl1 + "\n2) " + exp2 + "\t" + anl2 + "\n3) " + exp3 + "\t" + anl3);
                    System.out.println("Thank you for trying out my services. Since this is my Alpha version, I don't have much more than that, so stay tuned for when my programmers make me a little smarter.\nI hope you learned something about yourself! Thanks!");
                    end = false; System.exit(0); //end program gracefully
                }
                else if(x.equals("no")||x.equals("n")||x.contains("no"))
                {
                    if(i == 1 || i == 3 || i == 5)
                    {
                        System.out.println("Oh. What's troubling you?");
                        System.out.print(">");
                        scan.nextLine();
                        System.out.println("I see. Well " + name + ", I wish I could do more to help. As you can see, I'm just a program in this computer.");
                        System.out.print(">");
                        scan.nextLine();
                        System.out.println("Quite. You're awesome. I'm going to proceed, if I may.");
                        if(i == 5)
                            i = 1; //reset
                    }
                    else
                    {
                        System.out.println("Sorry, is something the matter?");
                        System.out.print(">");
                        scan.nextLine();
                        System.out.println("I see. Well " + name + ", I wish I could do more to assist you. As you can probably tell, I'm just a computer program.");
                        System.out.print(">");
                        scan.nextLine();
                        System.out.println("Of course. Now, I'm going to go on, if I may.");
                    }
                }
                else
                    genericElse();
                System.out.print(">");
                x = scan.nextLine().toLowerCase();
                i++;
            }
        }
    }
}
