from appium import webdriver
import  time
from PIL import Image
from pytesseract import image_to_string


desired_cap={
"platformName": "android",
  "appPackage": "tv.hooq.android",
  "deviceName": "Galaxy_Nexus_API_26",
  "app": "/Users/tconnect/Downloads/210.apk"
}

driver= webdriver.Remote("http://localhost:4723/wd/hub",desired_cap)

#driver.implicitly_wait(10000)

driver.find_element_by_id("tv.hooq.android:id/accountLogin").click()

driver.find_element_by_id("tv.hooq.android:id/emailInput").send_keys("afsar123@gmail.com")

#press tab from keyboard
driver.press_keycode(61)

driver.hide_keyboard()

driver.find_element_by_id("tv.hooq.android:id/emailDone").click()

time.sleep(2)

driver.save_screenshot("./Screenshots/Loginscreen.png")


##OCR to Read Text from theimage : As Appium doesnot provide any support for toast message

text_from_image=image_to_string(Image.open('./Screenshots/Loginscreen.png'))

print (text_from_image)

if text_from_image.find("Account does not exist.") == -1:

    print ("This email is  Valid , Successfully login !!")
else:
    print ("This email is not Valid , Try Again !!")


