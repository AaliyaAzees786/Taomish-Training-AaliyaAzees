import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appTooltip]',
  standalone: false
})
export class TooltipDirective {

  private tooltipMap = new WeakMap<HTMLElement, HTMLElement>();
  tooltipText: string = "This is Required";
  constructor(private el: ElementRef, private renderer: Renderer2) {}

  @HostListener('mouseenter') onMouseEnter(){
    if (!this.tooltipMap.has(this.el.nativeElement)) {
      const tooltip = this.renderer.createElement('span');
      tooltip.innerText = this.tooltipText;
      this.renderer.appendChild(document.body, tooltip);

      this.renderer.setStyle(tooltip, 'position', 'absolute');
      this.renderer.setStyle(tooltip, 'background', 'black');
      this.renderer.setStyle(tooltip, 'color', 'white');
      this.renderer.setStyle(tooltip, 'padding', '0.3rem');
      this.renderer.setStyle(tooltip, 'border-radius', '0.3rem');
      this.renderer.setStyle(tooltip, 'font-size', '0.75rem');

      const rect = this.el.nativeElement.getBoundingClientRect();
      this.renderer.setStyle(tooltip, 'top', `${rect.top - 30}px`);
      this.renderer.setStyle(tooltip, 'left', `${rect.left}px`);

      this.tooltipMap.set(this.el.nativeElement, tooltip);
    }
  }

  @HostListener('mouseleave') onMouseLeave() {
    const tooltip = this.tooltipMap.get(this.el.nativeElement);
    if (tooltip) {
      this.renderer.removeChild(document.body, tooltip);
      this.tooltipMap.delete(this.el.nativeElement);
    }
  }
  }
