'1
Sub effacerB2()
Dim a As Integer


    a = InputBox("entrez la valeur de a!")
   
   If a > 18 Then
    Debug.Print "vous etes majeur"
    Else
    Debug.Print "vous etes mineur"
   End If
End Sub
==========================================================================================
'2
Sub deuxiemefonction()  'vrai'
End Sub	
MsgBox ("bonjour " & Prenom) 'afficher un message bonjour et une variable prenom pré-déclarée 

Sub test()
Dim a As Byte 'le type byte il ne doit pas dépasser 255
a = 500 '''depassement de capacité"
End Sub
=======================================================================================
'3 tableau
Sub tablo()
Dim tablo(1, 1)
tablo(0, 0) = 1
tablo(0, 1) = 2
tablo(1, 0) = 3
tablo(1, 1) = 4
Debug.Print tablo(0, 1)

End Sub
=============================================================================================
'4 afficher le tableau
Sub tabo1()
Dim tablo1(2, 2)
tablo1(0, 0) = 1
tablo1(0, 1) = 2
tablo1(0, 2) = 5
'---------------
tablo1(1, 0) = 3
tablo1(1, 1) = 4
tablo1(1, 2) = 6
'--------------
tablo1(2, 0) = 7
tablo1(2, 1) = 8
tablo1(2, 2) = 9
For l = 0 To 2
    For c = 0 To 2
    Debug.Print tablo1(l, c)
    Next
Next
End Sub
============================================================================================================
'5declarer un tableau et l'afficher sur excel
Option Base 1

Sub test4()


Dim tablo(2, 2)
tablo(1, 1) = "a"
tablo(1, 2) = "b"
tablo(2, 1) = "c"
tablo(2, 2) = "d"
For c = 1 To 2
	For i = 1 To 2
		Application.Workbooks(1).Worksheets(1).Cells(i, c) = tablo(i, c)
	Next
Next
End Sub
========================================================================================================================
'6 déclarer un tableau a une dimension
Sub htcompass()
Dim rachid As Variant

rachid = Array(0, 1, 2, 3, 4, 5, 6, 7)

For i = 0 To 7
    Debug.Print rachid(i)
Next
End Sub
=====================================================================================================
'7 appeler une fonction par une autre avec ses variables
Option Explicit
Option Compare Binary
Public reponse As String 'declarer des variables publics
Public Sub afficher_demander() 'déclarer la fonction public 

MsgBox "bonjour, une fenêtre apparait avec ce message. Validez avec [OK]"
reponse = InputBox("c'est quoi votre prénom ?")

Call salim 'appeler la fonction

End Sub
= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  ================================================
Option Explicit
Option Compare Binary
Public i As Integer 'declarer les variables public
Public x As Integer
Public Sub salim() 'declarer la fonction public
x = Len(reponse) 'la taille d'une chaine de caractère

For i = 0 To 9

If x > 2 Then ' si la taille rentrée est >  2 donc le programme emet un un message positif sinon le programme conseille de rentrer un vrai renom
Debug.Print reponse & " est un très bon élève, il peut passer en big data "
Else
Debug.Print " merci de renseigner votre nom pour que je vous encourage "
End If
Next

End Sub
===========================================================================================================
'Exemple 2 - utilisation des variables
Texte1 = "Premier texte..."
Texte2 = "Second texte..."

    'Exemple 2A - sans retour à la ligne==================
    MsgBox Texte1 & " " & Texte2

    'Exemple 2B - avec retour à la ligne===============
    MsgBox Texte1 & Chr(13) & Chr(10) & Texte2
    
End Sub
=================================================================================================

Type contact'déclaration de variable contactde notre besoin, elle contient 4 variables
    Nom As String
    Prenom As String
    age As Integer
    tel As String
    adresse As String
    code_postal As String
End Type
    
Sub exemple() 'programme qui remplit un tableau sur excel avec

    'Déclaration
    Dim user1 As Utilisateur
    Dim i As Integer
    i = Application.Workbooks(1).Worksheets(1).Cells(1, 8)
    
   For i = i + 1 To i + 100 'i+1 par ce que il ne faut pas écraser les anciennes valeurs ddéja existante dans le tableau
    'Attributions des valeurs à user1
    user1.Nom = InputBox("Entrez votre nom")
    user1.Prenom = InputBox("Entrez votre prénom")
      user1.age = InputBox("Entrez votre age")
    user1.tel = InputBox("Entrez votre numero tel")
    user1.adresse = InputBox("Entrez votre adress")
    user1.code_postal = InputBox("Entrez votre code postal")
     
     choix = InputBox("voulez-vous continuer")
     
    

   Application.Workbooks(1).Worksheets(1).Cells(1, 8) = i 'on garde la valeur 
   'de i afin de ne pas écraser les anciennes
   'données plus tard
   
    Application.Workbooks(1).Worksheets(1).Cells(i, 1) = user1.Nom
    Application.Workbooks(1).Worksheets(1).Cells(i, 2) = user1.Prenom
    Application.Workbooks(1).Worksheets(1).Cells(i, 3) = user1.tel

    Application.Workbooks(1).Worksheets(1).Cells(i, 5) = user1.code_postal
     If choix = "NON" Then
     Stop
        Else
     End If
  next
  
    'Exemple d'utilisation
    'MsgBox user1.Nom & " " & user1.Prenom & " " & user1.tel
    Debug.Print user1.Nom & " " & user1.Prenom & " " & user1.age

End Sub

======================================================================================================================
'initialiser un tableau à 1 dimension et le remplir avec des variables de 0 ou 1
Sub htcompass()

Dim i As Integer
Dim rachid(1 To 10) As Integer

For i = 1 To 10
    If i Mod 2 = 1 Then
        rachid(i) = 1
    
    Else: rachid(i) = 0
    End If
    Next
   
Debug.Print rachid(5)
End Sub
==================================================================================================================
Sub aleatoire()
Dim i As Integer
Dim x As Integer

    'Initialiser le générateur de nombres aléatoires
    '=> Randomize : à ajouter avant d'utiliser Rnd pour obtenir des valeurs complètement aléatoires
   For i = 1 To 250
   x = InputBox(" devinette, choisissez un nombre inférieur à 250") 'devinette
   
    Randomize
    
    nombre_aleatoire = Int(250 * Rnd) + 1 'Nombre aléatoire entier entre 1 et 250 :
    
    If x < nombre_aleatoire Then
    MsgBox ("vous vous êtes trompez veuillez réessayer et rentenenter votre chance")
    Else
    MsgBox ("bravo votre réponse est correcte")
    Stop ''le programme s'arrete tout seul apres avoir gagné
    
    End If
    Next
    
End Sub
================================================================================================================
'fonction
Function monCarre(b As Integer) As Integer 'déclaration de la fonction avec ses paramètres et ses retours
     monCarre = b * b 'le retour
End Function
= = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =  = = = = = = = = = =  = = = = = = = = = = = = = = =
 Sub testerFonction() 'tester la fonction déclarée précedemment
    Dim b As Integer
    Dim carre As Integer
    b = InputBox("entrez une valeur")
   carre = monCarre(b)
    MsgBox carre 'afficher le résultat 
End Sub
==================================================================================================================
Sub tablo() 'programme qui initialise un tableau et qui le remplit  alternativement avec salim et hakim
For i = 1 To 5 Step 2
    For j = 1 To 5 Step 2
        Application.Workbooks(1).Worksheets(1).Cells(i, j) = "Salim"
    Next
Next

For i = 2 To 5 Step 2
    For j = 2 To 5 Step 2
        Application.Workbooks(1).Worksheets(1).Cells(i, j) = "Hakim"
    Next
Next

End Sub
= = = = = = = =  = = = = = = = = = = = =  = = = =  = = = = = = =
For i = 1 To 5' une autre façon de faire
    For j = 1 To 5
        If i Mod 2 = O And j Mod 2 = 0 Then
        Application.Workbooks(1).Worksheets(1).Cells(i, j) = "hakim"
             Else
        Application.Workbooks(1).Worksheets(1).Cells(i, j) = "salim"
         'else if i mod
        'els
        End If
    Next
 Next
 For k = 1 To 5
    For m = 2 To 5
        If k Mod 2 = 1 And m Mod 2 = O Then
        Application.Workbooks(1).Worksheets(1).Cells(m, k) = "salim"
             Else
        Application.Workbooks(1).Worksheets(1).Cells(m, k) = "hakim"
         'else if i mod
        'els
        End If
    Next
 Next