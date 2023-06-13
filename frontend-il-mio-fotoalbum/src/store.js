import { reactive } from "vue";

export const store = reactive({
  API_URL: "http://localhost:8080/api/v1",
  DEFAULT_IMG_URL:
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwWieQ-4kYhiLJUdZ8LV3PXqaIg9oqvRk-8Q&usqp=CAU",

  verifyImgPresence(imgPath) {
    return imgPath ? imgPath : this.DEFAULT_IMG_URL;
  },

  isValidEmail(email) {
    const emailPattern = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
    return emailPattern.test(email);
  },

  hasTotCharacters(strLng, minLng, maxLng) {
    return strLng >= minLng && strLng <= maxLng ? true : false;
  },
});
