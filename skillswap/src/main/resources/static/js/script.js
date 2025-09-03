// Hero Slider
const slides = document.querySelectorAll('.slide');
let currentSlide = 0;

function showSlide(i) {
  slides.forEach(s => s.classList.remove('active'));
  slides[i].classList.add('active');
}

function nextSlide() {
  currentSlide = (currentSlide + 1) % slides.length;
  showSlide(currentSlide);
}

setInterval(nextSlide, 5000);

// Mobile menu (future use)
document.getElementById('mobileMenuBtn').addEventListener('click', () => {
  // You can toggle mobile menu here
});

// About Us Modal
// About Us Modal Logic
const aboutModal = document.getElementById('aboutModal');
const aboutLink = document.getElementById('aboutLink');       // Navbar link
const aboutLinkFooter = document.getElementById('aboutLinkFooter'); // Footer link
const closeAbout = document.getElementById('closeAbout');

function openAboutModal() {
  aboutModal.classList.remove('hidden');
}

aboutLink.addEventListener('click', openAboutModal);
aboutLinkFooter.addEventListener('click', openAboutModal);

closeAbout.addEventListener('click', () => {
  aboutModal.classList.add('hidden');
});

aboutModal.addEventListener('click', (e) => {
  if (e.target === aboutModal) {
    aboutModal.classList.add('hidden');
  }
});
