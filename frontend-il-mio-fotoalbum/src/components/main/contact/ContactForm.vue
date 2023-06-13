<script>
import { store } from "../../../store";
export default {
  name: "ContactForm",

  data() {
    return {
      store,

      contactMessageInfos: {
        email: "",
        content: "",
      },

      errorsMessages: {
        email: [],
        content: [],
      },
    };
  },

  methods: {
    sendContactMessageInfos() {
      if (this.checkDatasValidity()) {
        this.$emit("contact-form-messages", this.contactMessageInfos);
      }
    },

    checkDatasValidity() {
      if (
        !this.store.hasTotCharacters(
          this.contactMessageInfos.email.length,
          0,
          0
        )
      ) {
        this.errorsMessages.email.push("L'email non può essere vuota");
        return false;
      }
      if (
        !this.store.hasTotCharacters(
          this.contactMessageInfos.content.length,
          0,
          0
        )
      ) {
        this.errorsMessages.content.push("Il contenuto non può essere vuoto");
        return false;
      }
      if (
        !this.store.hasTotCharacters(
          this.contactMessageInfos.email.length,
          3,
          100
        )
      ) {
        this.errorsMessages.email.push(
          "L'email deve avere un numero di caratteri compreso tra 3 e 100"
        );
        return false;
      }
      if (
        !this.store.hasTotCharacters(
          this.contactMessageInfos.content.length,
          10,
          255
        )
      ) {
        this.errorsMessages.content.push(
          "Il contenuto deve avere un numero compreso tra 10 e 255"
        );
        return false;
      }
      if (!this.store.isValidEmail(this.contactMessageInfos.email)) {
        this.errorsMessages.email.push("Non hai inserito un'email valida");
      }
    },
  },
};
</script>

<template>
  <form @submit.prevent="sendContactMessageInfos">
    <div class="my_form-el">
      <input
        type="email"
        v-model="contactMessageInfos.email"
        placeholder="Inserisci la tua email"
        maxlength="255"
        required
      />
      <div v-if="errorsMessages.email" class="my_error-container">
        <span v-for="error in errorsMessages.email" class="text-danger"
          >Errore: {{ error }}</span
        >
      </div>
    </div>
    <div class="my_form-el">
      <textarea
        id=""
        cols="30"
        rows="10"
        placeholder="Inserisci descrizione"
        v-model="contactMessageInfos.content"
        maxlength="255"
        required
        >{{ contactMessageInfos.content }}</textarea
      >
      <div v-if="errorsMessages.content" class="my_error-container">
        <span v-for="error in errorsMessages.content" class="text-danger"
          >Errore: {{ error }}</span
        >
      </div>
    </div>

    <button type="submit">Invia messaggio</button>
  </form>
</template>

<style scoped></style>
