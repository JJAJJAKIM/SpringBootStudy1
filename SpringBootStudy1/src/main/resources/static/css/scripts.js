document.addEventListener("DOMContentLoaded", () => {
    const menuLinks = document.querySelectorAll(".side-menu a");
    const sections = document.querySelectorAll("main section");

    menuLinks.forEach(link => {
        link.addEventListener("click", (e) => {
            e.preventDefault();
            const targetId = link.getAttribute("href").substring(1);
            sections.forEach(section => {
                section.style.display = section.id === targetId ? "block" : "none";
            });
        });
    });
});
