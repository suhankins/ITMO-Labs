ORG 0x54F
FSTPRINT:   WORD ?
COUNTER: 	WORD ?
PTRCOPY:	WORD ?
POINTER: 	WORD 0x553
STRING:     WORD 0x7, 0xD2F0, 0xD7C9, 0xD4C5, 0x0021 ; "Привет!"

ORG 0x57C
START:		CLA				; initialization
			ST FSTPRINT
			ST COUNTER
			LD POINTER
			ST PTRCOPY

READY:		IN 7			; keys pressed i guess?
			AND #0x40		; ready?
			BEQ READY		; if not, keep waiting
			IN 6			; resetting ready flag

			LD COUNTER
			ASR				; if we have carry flag - odd counter
			LD (PTRCOPY)
			BCC AFTER_SW
			SWAB
AFTER_SW: 	OUT 6			; printing them

			BCC EVEN		; IF ODD
			LD PTRCOPY		; NEXT 16 BITS
			INC
			ST PTRCOPY
			
EVEN:		LD FSTPRINT		
			BNE NOTFIRST	; IF this is the first symbol
			INC
			ST FSTPRINT		; set flag to 1
			LD PTRCOPY
			INC
			ST PTRCOPY		; next 16 bits
			LD COUNTER
			DEC
			ST COUNTER		; dec counter

NOTFIRST:   LD COUNTER		; next counter
			INC
			ST COUNTER
			SUB STRING		; we reached last symbol?
			BNE READY		; if no, go back to ready
			HLT