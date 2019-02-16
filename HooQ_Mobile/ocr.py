from PIL import Image
from pytesseract import image_to_string

img=Image.open('./Screenshots/Loginscreen.png')

pytesseract.pytesseract.tesseract_cmd=''

text=image_to_string(img)

print(text)


#print (image_to_string(Image.open('./Screenshots/Loginscreen.png')))
#print (image_to_string(Image.open('test-english.jpg'), lang='eng'))
