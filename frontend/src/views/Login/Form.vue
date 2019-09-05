<template>
  <div class="row justify-content-center">
    <div class="col-4">
      <b-card-group deck class="deck">
        <b-card
          border-variant="primary"
          title="Login"
          header-bg-variant="primary"
          header-text-variant="white"
          align="center"
        >
          <b-card-text>
            <b-form>
              <b-form-group label="Email" description="Ex.: exemplo@exemplo.com">
                <b-form-input
                  v-model="form.email"
                  type="email"
                  required
                  placeholder="Digite seu e-mail de acesso"
                  class="text-center"
                ></b-form-input>
              </b-form-group>

              <b-form-group label="Password">
                <b-form-input v-model="form.password" type="password" required></b-form-input>
              </b-form-group>
              <b-button class="text-center" type="submit" variant="primary">Login</b-button>
            </b-form>
          </b-card-text>
        </b-card>
      </b-card-group>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        email: "",
        password: ""
      }
    };
  }
};
</script>

<style scoped>
.deck {
  margin-top: 20%;
}
</style>