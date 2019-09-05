<template>
  <div>
    <Navbar></Navbar>
    <Container>
      <router-view />
    </Container>
  </div>
</template>

<script>
import Navbar from "@/components/Navbar";
import Container from "@/components/Container";

export default {
  data() {
    return {};
  },
  components: { Navbar, Container }
};
</script>