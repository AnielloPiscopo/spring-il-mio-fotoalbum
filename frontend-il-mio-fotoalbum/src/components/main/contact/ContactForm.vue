<script>
export default {
  name: "ContactForm",

  data() {
    return {
      contactMessageInfos: {
        email: "",
        content: "",
      },
    };
  },

  methods: {
    sendContactMessageInfos() {
      this.$emit("contact-form-messages", this.contactMessageInfos);
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
      />
    </div>
    <div class="my_form-el">
      <textarea
        id=""
        cols="30"
        rows="10"
        placeholder="Inserisci descrizione"
        v-model="contactMessageInfos.content"
        >{{ contactMessageInfos.content }}</textarea
      >
    </div>

    <button type="submit">Invia messaggio</button>
  </form>
</template>

<style scoped></style>
