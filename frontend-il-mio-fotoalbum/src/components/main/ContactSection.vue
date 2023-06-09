<script>
import { store } from "../../store";
import axios from "axios";

import ContactForm from "./contact/ContactForm.vue";

export default {
  name: "ContactSection",

  components: {
    ContactForm,
  },

  data() {
    return {
      store,
      apiUrlSpecificSection: "/contact-messages/store",
      contactMessage: {
        email: "",
        content: "",
      },
    };
  },

  methods: {
    storeContactMessageInDb() {
      axios
        .post(
          this.store.API_URL + this.apiUrlSpecificSection,
          this.contactMessage
        )
        .then((res) => console.log("Oggetto creato con successo", res.data))
        .catch((err) => console.error(err));
    },

    getContactMessageInfos(contactMessageInfos) {
      this.contactMessage = contactMessageInfos;
      this.storeContactMessageInDb();
    },
  },
};
</script>

<template>
  <section id="contact">
    <h1>Zona contatti</h1>
    <ContactForm @contact-form-messages="getContactMessageInfos" />
  </section>
</template>

<style scoped></style>
